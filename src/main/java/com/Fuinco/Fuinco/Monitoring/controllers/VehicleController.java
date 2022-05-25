package com.Fuinco.Fuinco.Monitoring.controllers;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.VehicleLastDataListResponse;
import com.Fuinco.Fuinco.Monitoring.exception.ApiGetException;
import com.Fuinco.Fuinco.Monitoring.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Assem
 */
@RestController
@RequestMapping(path = "/devicesTaxi")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/getVehicleLastDataList")
    public @ResponseBody ResponseEntity<ApiResponse<List<VehicleLastDataListResponse>>> getVehicleLastDataList(@RequestParam (value = "userId") Long userId,
                                                                                                               @RequestParam(value = "search", defaultValue = "") String search,
                                                                                                               @RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                                                               @RequestParam (value = "size",defaultValue = "0") int size){
        try{
            return ResponseEntity.ok(vehicleService
                    .getVehicleLastDataList(userId,search,offset,size));
        }catch (Exception | Error e){
           throw new ApiGetException(e.getLocalizedMessage());
        }
    }
}
