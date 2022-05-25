package com.Fuinco.Fuinco.Monitoring.entities;

import java.util.Date;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewcustomerDivice {
    private int id;
    private String deviceName;
    private Date lastUpdate;
    private Integer positionId;
    private String driverName;
    private String leftLetter;
    private String middleLetter;
    private String rightLetter;
}
