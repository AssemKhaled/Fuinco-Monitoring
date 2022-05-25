package com.Fuinco.Fuinco.Monitoring.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleLastDataListResponse {

    private Long id;
    private String name;
    private String driverName;
    private String lastUpdate;
    private String sequence_number;
    private String status;
    private String tripStatus;
    private Double currentCost;
    private Integer numOfPassengers;

}
