package br.com.fiap.onepieceapi.controller;

import br.com.fiap.onepieceapi.model.Crew;
import br.com.fiap.onepieceapi.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crews")
@RequiredArgsConstructor
public class CrewController {

    private final CrewService service;

    @GetMapping
    public List<Crew> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Crew findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Crew save(@RequestBody Crew crew) {
        return service.save(crew);
    }

    @PutMapping("/{id}")
    public Crew update(@PathVariable Long id, @RequestBody Crew crew) {
        return service.update(id, crew);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}