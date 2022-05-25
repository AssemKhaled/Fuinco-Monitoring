package com.Fuinco.Fuinco.Monitoring.entities;

import java.util.Date;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LastLocationsList {
    private String id;
    private Date lasttime;
    private Long deviceid;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private Object attributes;
    private Date devicetime;
    private String deviceRK;
    private String driver_RK;
    private Long driverid;
    private String drivername;
    private Double weight;
    private String address;
    private String devicename;


}
