package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.MongoActivities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoActivitiesRepository extends MongoRepository<MongoActivities, String> {
}
