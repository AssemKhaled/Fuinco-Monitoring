package com.Fuinco.Fuinco.Monitoring.dto.response;

import lombok.*;

/**
 * @author Assem
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverListResponse {

    private Long id;
    private String name;// sql D
    private String vehicleName;// sql V
    private String mobileNumber;// sql D
    private String status;//func
    private Double currentTripCost;//mongo
    private Integer numberOfPassengers;//mongo
    private String lastLocationTime;//mongo

}
