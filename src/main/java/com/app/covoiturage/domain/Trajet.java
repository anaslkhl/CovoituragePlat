
package com.app.covoiturage.domain;

import com.app.covoiturage.domain.enums.StatutTrajet;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "trajets")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime dateDepart;

    @Column(nullable = false)
    private Integer placesProposees;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutTrajet statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;

    @OneToMany(
            mappedBy = "trajet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("ordre ASC")
    @Builder.Default
    private List<PointArret> pointsArret = new ArrayList<>();

    @OneToMany(mappedBy = "trajet")
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();
}
