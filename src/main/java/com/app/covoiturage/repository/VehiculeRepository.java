package com.app.covoiturage.repository;

import com.app.covoiturage.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VehiculeRepository extends JpaRepository<Vehicule, UUID> {

    boolean existsByImmatriculation(String immatriculation);

    List<Vehicule> findByConducteurId(UUID conducteurId);
}