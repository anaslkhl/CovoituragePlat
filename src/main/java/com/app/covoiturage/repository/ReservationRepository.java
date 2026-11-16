
package com.app.covoiturage.repository;

import com.app.covoiturage.domain.Reservation;
import com.app.covoiturage.domain.enums.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByTrajetIdAndStatut(
            UUID trajetId,
            StatutReservation statut
    );

    boolean existsByPassagerIdAndTrajetIdAndStatut(
            UUID passagerId,
            UUID trajetId,
            StatutReservation statut
    );

    @Query("""
            SELECT COALESCE(SUM(r.nombrePlaces), 0)
            FROM Reservation r
            WHERE r.trajet.id = :trajetId
              AND r.statut = :statut
            """)
    Long sumNombrePlacesByTrajetIdAndStatut(
            @Param("trajetId") UUID trajetId,
            @Param("statut") StatutReservation statut
    );
}
