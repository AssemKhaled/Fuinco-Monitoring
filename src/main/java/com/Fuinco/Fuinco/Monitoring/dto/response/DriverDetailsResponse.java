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
public class DriverDetailsResponse {

    private Long id;
    private String name;
    private String email;
    private String licenseNo;
    private String birthDate;
    private String mobileNum;
    private String activity;
    private String photo;

}
