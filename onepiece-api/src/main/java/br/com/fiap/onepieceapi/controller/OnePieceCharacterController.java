package br.com.fiap.onepieceapi.controller;

import br.com.fiap.onepieceapi.model.OnePieceCharacter;
import br.com.fiap.onepieceapi.projection.CharacterSummaryProjection;
import br.com.fiap.onepieceapi.service.OnePieceCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class OnePieceCharacterController {

    private final OnePieceCharacterService service;

    @GetMapping
    public Page<EntityModel<OnePieceCharacter>> findAll(Pageable pageable) {
        return service.findAll(pageable)
                .map(this::toEntityModel);
    }

    @GetMapping("/{id}")
    public EntityModel<OnePieceCharacter> findById(@PathVariable Long id) {
        return toEntityModel(service.findById(id));
    }

    @GetMapping("/crew/{crewId}")
    public Page<EntityModel<OnePieceCharacter>> findByCrewId(
            @PathVariable Long crewId,
            Pageable pageable
    ) {
        return service.findByCrewId(crewId, pageable)
                .map(this::toEntityModel);
    }

    @GetMapping("/search")
    public Page<CharacterSummaryProjection> findByName(
            @RequestParam String name,
            Pageable pageable
    ) {
        return service.findByName(name, pageable);
    }

    @PostMapping
    public EntityModel<OnePieceCharacter> save(@RequestBody OnePieceCharacter character) {
        return toEntityModel(service.save(character));
    }

    @PutMapping("/{id}")
    public EntityModel<OnePieceCharacter> update(
            @PathVariable Long id,
            @RequestBody OnePieceCharacter character
    ) {
        return toEntityModel(service.update(id, character));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private EntityModel<OnePieceCharacter> toEntityModel(OnePieceCharacter character) {
        return EntityModel.of(
                character,
                linkTo(methodOn(OnePieceCharacterController.class).findById(character.getId())).withSelfRel(),
                linkTo(methodOn(OnePieceCharacterController.class).findAll(Pageable.unpaged())).withRel("all-characters"),
                linkTo(methodOn(OnePieceCharacterController.class).findByCrewId(character.getCrew().getId(), Pageable.unpaged())).withRel("same-crew")
        );
    }
}