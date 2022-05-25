package com.Fuinco.Fuinco.Monitoring.controllers;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverListResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverDetailsResponse;
import com.Fuinco.Fuinco.Monitoring.exception.ApiGetException;
import com.Fuinco.Fuinco.Monitoring.services.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Assem
 */
@RestController
@RequestMapping(path = "/driversTaxi")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "/getDriversList")
    public @ResponseBody ResponseEntity<ApiResponse<List<DriverListResponse>>> getDriversList(@RequestParam(value = "userId") Long userId,
                                                                                              @RequestParam(value = "search", defaultValue = "") String search,
                                                                                              @RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                                              @RequestParam (value = "size",defaultValue = "0") int size){
        try{
            return ResponseEntity.ok(driverService.getDriversList(userId,search,offset,size));
        }catch (Exception | Error e){
            throw new ApiGetException(e.getLocalizedMessage());
        }
    }
    @GetMapping(value = "/getDriverDetails")
    public @ResponseBody ResponseEntity<ApiResponse<DriverDetailsResponse>> getDriverDetails(@RequestParam(value = "driverId") Long driverId){
        try{
            return ResponseEntity.ok(driverService.getDriverDetails(driverId));
        }catch (Exception | Error e){
            throw new ApiGetException(e.getLocalizedMessage());
        }
    }

}
