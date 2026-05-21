package br.com.fiap.onepieceapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnePieceCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String role;

    private String bounty;

    private String status;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne
    @JoinColumn(name = "devil_fruit_id")
    private DevilFruit devilFruit;
}