package br.com.fiap.onepieceapi.service;

import br.com.fiap.onepieceapi.model.Crew;
import br.com.fiap.onepieceapi.repository.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CrewService {

    private final CrewRepository repository;

    public List<Crew> findAll() {
        return repository.findAll();
    }

    public Crew findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Tripulação não encontrada"));
    }

    public Crew save(Crew crew) {
        return repository.save(crew);
    }

    public Crew update(Long id, Crew crew) {
        Crew found = findById(id);

        found.setName(crew.getName());
        found.setShipName(crew.getShipName());
        found.setOriginSea(crew.getOriginSea());

        return repository.save(found);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}