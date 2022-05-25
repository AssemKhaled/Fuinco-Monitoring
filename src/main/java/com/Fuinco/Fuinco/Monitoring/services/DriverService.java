package com.Fuinco.Fuinco.Monitoring.services;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverListResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverDetailsResponse;

import java.util.List;

/**
 * @author Assem
 */
public interface DriverService {
    ApiResponse<List<DriverListResponse>> getDriversList(Long userId , String search , int offset , int size);
    ApiResponse<DriverDetailsResponse> getDriverDetails(Long driverId);
}
