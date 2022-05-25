package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.Device;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

//    @Query(value = "SELECT * FROM tc_devices where  tc_devices.lastupdate>date_sub(now(), interval 8 minute)=falseAND tc_devices.id IN (:deviceIds) and tc_devices.delete_date is null and tc_devices.positionid is not null", nativeQuery = true)
//    List<Device> getOnlineDevicesByIds(@Param("deviceIds")List<Long> deviceIds);
//
//    @Query(value = "SELECT * FROM tc_devices where tc_devices.lastupdate>date_sub(now(), interval 3 minute)=false  AND tc_devices.lastupdate<date_sub(now(), interval 8 minute)=false AND tc_devices.id IN (:deviceIds) and tc_devices.delete_date is null and tc_devices.positionid is not null", nativeQuery = true)
//    List<Device> getOfflineDevicesByIds(@Param("deviceIds")List<Long> deviceIds);
//
//    @Query(value = "SELECT * FROM tc_devices INNER JOIN tc_user_device ON tc_user_device.deviceid=tc_devices.id where tc_devices.lastupdate>date_sub(now(), interval 8 minute)=false AND tc_user_device.userid IN (:userIds) and tc_devices.delete_date is null and tc_devices.positionid is not null", nativeQuery = true)
//    List<Device> getOutOfNetworkDevicesByIds(@Param("userIds")List<Long> userIds);

    Optional<List<Device>> findAllByUser_idInAndDeleteDate(List<Long> userIds, Pageable pageable,String deleteDate);

    Optional<List<Device>> findAllByUser_idInAndDeleteDate(List<Long> userIds,String deleteDate);
    Optional<List<Device>> findDevicesByUser_idInAndDeleteDate(List<Long> userIds,String deleteDate);
    Optional<List<Device>> findDevicesByUser_idInAndDeleteDate(List<Long> userIds, Pageable pageable,String deleteDate);

    Optional<List<Device>> findAllByDriverIdInAndDeleteDate(List<Long> driverIds , String deleteDate);
}
