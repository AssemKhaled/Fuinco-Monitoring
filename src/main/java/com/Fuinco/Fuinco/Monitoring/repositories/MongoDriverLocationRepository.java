package com.Fuinco.Fuinco.Monitoring.repositories;
import com.Fuinco.Fuinco.Monitoring.entities.MongoDriverLocation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MongoDriverLocationRepository extends MongoRepository<MongoDriverLocation,String>{

    Optional<List<MongoDriverLocation>> findAllBy_idIn(List<String> driverLastIds);
    Optional<List<MongoDriverLocation>> findTopByDriverIdIn(List<Long> driverIds);
}
