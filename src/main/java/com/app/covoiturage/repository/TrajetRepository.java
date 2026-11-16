package com.app.covoiturage.repository;

import com.app.covoiturage.domain.Trajet;
import com.app.covoiturage.domain.enums.StatutTrajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TrajetRepository extends JpaRepository<Trajet, UUID> {

    List<Trajet> findByConducteurId(UUID conducteurId);

    List<Trajet> findByStatut(StatutTrajet statut);

    List<Trajet> findByVehiculeId(UUID vehiculeId);

    List<Trajet> findByConducteurIdAndStatut(
            UUID conducteurId,
            StatutTrajet statut
    );

    @Query("""
        SELECT t
        FROM Trajet t
        WHERE t.statut = 'PUBLIE'
        AND t.dateDepart >= :dateDepart
        """)
    Page<Trajet> rechercherTrajets(
            @Param("dateDepart") LocalDateTime dateDepart,
            Pageable pageable
    );

}