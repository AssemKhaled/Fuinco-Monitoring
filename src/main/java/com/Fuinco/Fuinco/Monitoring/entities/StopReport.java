package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StopReport {
    private String address;
    private String averageSpeed;
    private Long deviceId;
    private String deviceName;
    private String distance;
    private String duration;
    private String endOdometer;
    private String endTime;
    private String engineHours;
    private String latitude;
    private String longitude;
    private String maxSpeed;
    private String positionId;
    private String spentFuel;
    private String startOdometer;
    private String startTime;
    private String driverName;
    private String driverUniqueId;


}
