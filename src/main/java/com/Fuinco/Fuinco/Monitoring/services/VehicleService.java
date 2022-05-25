package com.Fuinco.Fuinco.Monitoring.services;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.VehicleLastDataListResponse;

import java.util.List;
/**
 * @author Assem
 */
public interface VehicleService {

    ApiResponse<List<VehicleLastDataListResponse>> getVehicleLastDataList(Long userId , String search ,int offset , int size);
}
