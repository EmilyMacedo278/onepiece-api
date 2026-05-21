package br.com.fiap.onepieceapi.repository;

import br.com.fiap.onepieceapi.model.OnePieceCharacter;
import br.com.fiap.onepieceapi.projection.CharacterSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnePieceCharacterRepository extends JpaRepository<OnePieceCharacter, Long> {

    Page<OnePieceCharacter> findByCrewId(Long crewId, Pageable pageable);

    Page<CharacterSummaryProjection> findByNameContainingIgnoreCase(String name, Pageable pageable);
}