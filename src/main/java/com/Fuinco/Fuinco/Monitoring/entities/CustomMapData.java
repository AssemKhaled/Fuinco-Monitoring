package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomMapData {
    private Long id;
    private String deviceName;
    private String sequenceNumber;
    private String lastUpdate;
    private String lastUpdateApp;
    private String positionId;
    private Integer status;
    private Integer vehicleStatus;
    private Integer valid;
    private Integer ignition;
    private Double power;
    private Double operator;
    private Double latitude;
    private Double longitude;
    private Double speed ;
    private String address;
    private Double temperature;
    private Double humidity;
    private String icon;

}
