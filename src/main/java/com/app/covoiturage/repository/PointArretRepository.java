package com.app.covoiturage.repository;

import com.app.covoiturage.domain.PointArret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PointArretRepository extends JpaRepository<PointArret, UUID> {
}