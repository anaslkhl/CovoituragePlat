package com.app.covoiturage.repository;

import com.app.covoiturage.domain.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConducteurRepository extends JpaRepository<Conducteur, UUID> {

    boolean existsByNumeroPermis(String numeroPermis);

}