package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.MongoTowCarLiveLocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoTowCarLiveLocationRepository extends MongoRepository<MongoTowCarLiveLocationEntity,String> {
}
