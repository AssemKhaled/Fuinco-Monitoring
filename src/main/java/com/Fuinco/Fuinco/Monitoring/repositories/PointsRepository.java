package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Points;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRepository extends JpaRepository<Points, Long> {
}
