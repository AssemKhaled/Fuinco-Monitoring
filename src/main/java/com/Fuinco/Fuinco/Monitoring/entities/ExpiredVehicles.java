package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExpiredVehicles {
    private Long deviceId;
    private Long userId;
    private String vehicle_referenceKey;
    private String user_referenceKey;
    private String deviceName;
    private String userName;
}
