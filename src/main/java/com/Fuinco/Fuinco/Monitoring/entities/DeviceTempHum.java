package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DeviceTempHum {
    private String id;
    private Long deviceId;
    private String deviceName;
    private String driverName;
    private String servertime;
    private Object attributes;
    private Double speed;
    private Double weight;
    private Double temperature;
    private Double humidity;
}
