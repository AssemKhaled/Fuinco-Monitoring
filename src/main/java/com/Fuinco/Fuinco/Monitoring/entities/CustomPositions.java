package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomPositions {
    private String id;
    private Long deviceId;
    private String deviceName;
    private String driverName;
    private String servertime;
    private Object attributes; /* {"activity":"AIRPORT_TAXI"} */
    private Double speed;
    private Double weight;
    private Double sensor1;
    private Double sensor2;

}
