package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.MongoPositions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPositionsRepository extends MongoRepository<MongoPositions,String> {
}
