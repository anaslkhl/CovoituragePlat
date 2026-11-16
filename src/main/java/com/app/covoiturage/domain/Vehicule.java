
package com.app.covoiturage.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vehicules")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String modele;

    @Column(nullable = false, unique = true)
    private String immatriculation;

    @Column(nullable = false)
    private String couleur;

    @NonNull
    @Min(1)
    @Max(8)
    @Column(nullable = false)
    private Integer capacite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;
}
