package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledRepository extends JpaRepository<Schedule, Long> {
}
