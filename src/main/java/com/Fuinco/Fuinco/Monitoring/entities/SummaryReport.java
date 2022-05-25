package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SummaryReport {
    private String averageSpeed;
    private Long deviceId;
    private String deviceName;
    private String distance;
    private String endOdometer;
    private String engineHours;
    private String maxSpeed;
    private String spentFuel;
    private String startOdometer;
    private String driverName;
}
