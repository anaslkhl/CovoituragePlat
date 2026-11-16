package com.app.covoiturage.domain;

import com.app.covoiturage.domain.enums.StatutReservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer nombrePlaces;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dateReservation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passager_id", nullable = false)
    private Passager passager;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trajet_id", nullable = false)
    private Trajet trajet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_montee_id", nullable = false)
    private PointArret pointMontee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_descente_id", nullable = false)
    private PointArret pointDescente;
}