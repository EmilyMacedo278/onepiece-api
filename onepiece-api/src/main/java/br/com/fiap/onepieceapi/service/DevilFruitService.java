package br.com.fiap.onepieceapi.service;

import br.com.fiap.onepieceapi.model.DevilFruit;
import br.com.fiap.onepieceapi.repository.DevilFruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DevilFruitService {

    private final DevilFruitRepository repository;

    public List<DevilFruit> findAll() {
        return repository.findAll();
    }

    public DevilFruit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Akuma no Mi não encontrada"));
    }

    public DevilFruit save(DevilFruit devilFruit) {
        return repository.save(devilFruit);
    }

    public DevilFruit update(Long id, DevilFruit devilFruit) {
        DevilFruit found = findById(id);

        found.setName(devilFruit.getName());
        found.setType(devilFruit.getType());
        found.setPowerDescription(devilFruit.getPowerDescription());

        return repository.save(found);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}