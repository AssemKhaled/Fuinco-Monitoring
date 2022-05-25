package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TripReport {
    private String averageSpeed;
    private Long deviceId;
    private String deviceName;
    private String distance;
    private String driverName;
    private String driverUniqueId;
    private String duration;
    private String endAddress;
    private String endLat;
    private String endLon;
    private String endOdometer;
    private String endPositionId;
    private String endTime;
    private String maxSpeed;
    private String spentFuel;
    private String startAddress;
    private String startLat;
    private String startLon;
    private String startOdometer;
    private String startPositionId;
    private String startTime;

}
