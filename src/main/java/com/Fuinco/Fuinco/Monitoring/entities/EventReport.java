package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventReport {
    private String eventId;
    private String eventType;
    private String serverTime;
    private Object attributes;
    private Long deviceId;
    private String deviceName;
    private Long driverId;
    private String driverName;
    private Long geofenceId;
    private String geofenceName;
    private String positionId;
    private Double latitude;
    private Double longitude;
    private Long userId;
}
