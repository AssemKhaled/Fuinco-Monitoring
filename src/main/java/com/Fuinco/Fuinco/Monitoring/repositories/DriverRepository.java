package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Driver;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<List<Driver>> findAllByIdIn(List<Long> driverIds);
    Optional<List<Driver>> findAllByCompanyIdInAndDeleteDate(List<Integer> userIds, Pageable pageable, String deleteDate);
    Optional<List<Driver>> findAllByCompanyIdInAndDeleteDate(List<Integer> userIds , String deleteDate);
}
