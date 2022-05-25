package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputedRepository extends JpaRepository<Attribute, Long> {
}
