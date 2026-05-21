package br.com.fiap.onepieceapi.service;

import br.com.fiap.onepieceapi.model.OnePieceCharacter;
import br.com.fiap.onepieceapi.projection.CharacterSummaryProjection;
import br.com.fiap.onepieceapi.repository.OnePieceCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class OnePieceCharacterService {

    private final OnePieceCharacterRepository repository;
    private final CrewService crewService;
    private final DevilFruitService devilFruitService;

    @Cacheable("characters")
    public Page<OnePieceCharacter> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Cacheable("characterById")
    public OnePieceCharacter findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Personagem não encontrado"));
    }

    public Page<OnePieceCharacter> findByCrewId(Long crewId, Pageable pageable) {
        return repository.findByCrewId(crewId, pageable);
    }

    public Page<CharacterSummaryProjection> findByName(String name, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(name, pageable);
    }

    public OnePieceCharacter save(OnePieceCharacter character) {
        character.setCrew(crewService.findById(character.getCrew().getId()));
        character.setDevilFruit(devilFruitService.findById(character.getDevilFruit().getId()));

        return repository.save(character);
    }

    public OnePieceCharacter update(Long id, OnePieceCharacter character) {
        OnePieceCharacter found = findById(id);

        found.setName(character.getName());
        found.setRole(character.getRole());
        found.setBounty(character.getBounty());
        found.setStatus(character.getStatus());
        found.setCrew(crewService.findById(character.getCrew().getId()));
        found.setDevilFruit(devilFruitService.findById(character.getDevilFruit().getId()));

        return repository.save(found);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}