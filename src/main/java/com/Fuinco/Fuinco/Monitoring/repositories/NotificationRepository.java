package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
