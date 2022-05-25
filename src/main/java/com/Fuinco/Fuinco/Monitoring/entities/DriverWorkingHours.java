package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DriverWorkingHours {
    private String deviceTime;
    private String positionId;
    private Object attributes;
    private Long deviceId;
    private String driverName;
    private String hours;
    private String deviceName;
    private String startTime;
    private String endTime;

}
