package com.Fuinco.Fuinco.Monitoring.dto.response;

import lombok.*;

import java.util.List;
import java.util.Map;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetObjectResponse {
    private Integer responseCode;
    private String  message;
    private List<?> entity;
    private Map<Object, Object> sensorSettings;
    private Integer size;

}
