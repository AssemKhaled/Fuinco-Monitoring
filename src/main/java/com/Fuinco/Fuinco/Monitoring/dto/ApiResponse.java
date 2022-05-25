package com.Fuinco.Fuinco.Monitoring.dto;

import lombok.*;
/**
 * @author Assem
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse<T> {

    private Integer statusCode;
    private Boolean success;
    private String message;
    private int size;
    private T body;
}
