package br.com.fiap.onepieceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.onepieceapi.model.Crew;

public interface CrewRepository extends JpaRepository<Crew, Long> {
    
}
