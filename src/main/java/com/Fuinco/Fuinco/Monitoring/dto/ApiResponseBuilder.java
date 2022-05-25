package com.Fuinco.Fuinco.Monitoring.dto;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import lombok.Setter;
/**
 * @author Assem
 */
@Setter
public class ApiResponseBuilder<T> {
    private Integer statusCode;
    private Boolean success;
    private String message;
    private int size;
    private T body;

    public ApiResponse<T> build(){
        return new ApiResponse<T>(this.statusCode,this.success,this.message,this.size,this.body);
    }
}
