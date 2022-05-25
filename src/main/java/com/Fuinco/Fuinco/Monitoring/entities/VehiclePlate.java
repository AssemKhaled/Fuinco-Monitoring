package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehiclePlate {
    String number;
    String rightLetter;
    String middleLetter;
    String leftLetter;

}
