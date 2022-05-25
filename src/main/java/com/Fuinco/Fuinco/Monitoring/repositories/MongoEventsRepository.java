package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.MongoEvents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEventsRepository extends MongoRepository<MongoEvents, String> {
}
