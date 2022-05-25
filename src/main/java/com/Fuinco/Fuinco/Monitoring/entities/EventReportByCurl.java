package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventReportByCurl {
    private Long id;
    private Object attributes;
    private Long deviceId;
    private String type;
    private String serverTime;
    private Long positionId;
    private Long geofenceId;
    private Long maintenanceId;
    private String deviceName;
    private String driverName;

}
