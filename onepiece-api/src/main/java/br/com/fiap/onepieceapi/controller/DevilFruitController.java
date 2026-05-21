package br.com.fiap.onepieceapi.controller;

import br.com.fiap.onepieceapi.model.DevilFruit;
import br.com.fiap.onepieceapi.service.DevilFruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devil-fruits")
@RequiredArgsConstructor
public class DevilFruitController {

    private final DevilFruitService service;

    @GetMapping
    public List<DevilFruit> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DevilFruit findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DevilFruit save(@RequestBody DevilFruit devilFruit) {
        return service.save(devilFruit);
    }

    @PutMapping("/{id}")
    public DevilFruit update(@PathVariable Long id, @RequestBody DevilFruit devilFruit) {
        return service.update(id, devilFruit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}