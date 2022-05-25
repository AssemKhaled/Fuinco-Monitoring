package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LastPositionData {
    private String positionId;

    private String servertime;

    private String devicetime;

    private String fixtime;

    private Double latitude;

    private Double longitude;

    private Double speed;

    private Double weight;

    private String address;


    private Object attributes;

}
