package com.app.covoiturage.repository;

import com.app.covoiturage.domain.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassagerRepository extends JpaRepository<Passager, UUID> {
}