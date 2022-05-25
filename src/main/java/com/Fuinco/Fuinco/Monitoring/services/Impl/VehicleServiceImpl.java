package com.Fuinco.Fuinco.Monitoring.services.Impl;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.ApiResponseBuilder;
import com.Fuinco.Fuinco.Monitoring.dto.response.VehicleLastDataListResponse;
import com.Fuinco.Fuinco.Monitoring.entities.Device;
import com.Fuinco.Fuinco.Monitoring.entities.Driver;
import com.Fuinco.Fuinco.Monitoring.entities.MongoDriverLocation;
import com.Fuinco.Fuinco.Monitoring.exception.ApiGetException;
import com.Fuinco.Fuinco.Monitoring.helper.Impl.AssistantServiceImpl;
import com.Fuinco.Fuinco.Monitoring.repositories.DeviceRepository;
import com.Fuinco.Fuinco.Monitoring.repositories.DriverRepository;
import com.Fuinco.Fuinco.Monitoring.repositories.MongoDriverLocationRepository;
import com.Fuinco.Fuinco.Monitoring.services.VehicleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Assem
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private final AssistantServiceImpl assistantServiceImpl;

    private final DeviceRepository deviceRepository;
    private final DriverRepository driverRepository;
    private final MongoDriverLocationRepository mongoDriverLocationRepository;
    private static final Log logger = LogFactory.getLog(VehicleServiceImpl.class);


    public VehicleServiceImpl(AssistantServiceImpl assistantServiceImpl, DeviceRepository deviceRepository, DriverRepository driverRepository, MongoDriverLocationRepository mongoDriverLocationRepository) {
        this.assistantServiceImpl = assistantServiceImpl;
        this.deviceRepository = deviceRepository;
        this.driverRepository = driverRepository;
        this.mongoDriverLocationRepository = mongoDriverLocationRepository;
    }


    @Override
    public ApiResponse<List<VehicleLastDataListResponse>> getVehicleLastDataList(Long userId, String search, int offset, int size) {

        ApiResponseBuilder<List<VehicleLastDataListResponse>> builder = new ApiResponseBuilder<>();
        String tripstatus;
        List<VehicleLastDataListResponse> results = new ArrayList<>();
        List<Long> userIds;
        userIds=assistantServiceImpl.getChildrenOfUser(userId);
        Optional<List<Device>> optionalDeviceList;
        if (size>0) {
            optionalDeviceList = deviceRepository.findDevicesByUser_idInAndDeleteDate(userIds ,PageRequest.of(offset,size),null);
        }else {
            optionalDeviceList = deviceRepository.findDevicesByUser_idInAndDeleteDate(userIds,null);
        }
        if (optionalDeviceList.isPresent()) {
            List<Device> deviceList = optionalDeviceList.get();
            if (search != "") {
                if (deviceList.size() > 0 && Pattern.matches(".*\\S.*", search)) {
                    deviceList = deviceList.stream().filter(device ->
                            device.getName().contains(search)).collect(Collectors.toList());
                }
            }else {
                builder.setBody(results);
                builder.setStatusCode(401);
                builder.setMessage("No Search Data Found");
                builder.setSize(results.size());
                builder.setSuccess(false);
                return builder.build();
            }
            List<Long> driverIds = new ArrayList<>();
            List<String> driverLastLocationIds = new ArrayList<>();
            for (Device device:deviceList) {
                driverIds.add(device.getDriverId());
                driverLastLocationIds.add(device.getDriver_last_location_id());
            }
            Optional<List<Driver>> optionalDriverList = driverRepository.findAllByIdIn(driverIds);
            if (optionalDriverList.isPresent()) {
                List<Driver> driverList = optionalDriverList.get();
                Optional<List<MongoDriverLocation>> optionalMongoDriverLocationList = mongoDriverLocationRepository.findAllBy_idIn(driverLastLocationIds);
                if (optionalMongoDriverLocationList.isPresent()) {
                    List<MongoDriverLocation> mongoDriverLocationList = optionalMongoDriverLocationList.get();
                    logger.info("Starting The Loop On Devices with size : "+deviceList.size());
                    for (Device device:deviceList) {
//                        logger.info("Device id Is before : "+device.getId());
                        String id = null;
                        String driverName;
                        Double cost = null;
                        Integer numOfPassengers = null;
                        try {
                            MongoDriverLocation currentLocation ;
                            List<MongoDriverLocation> currentLocations = mongoDriverLocationList.stream().filter(mongoDriverLocation -> mongoDriverLocation.getDriverId().equals(device.getDriverId())).collect(Collectors.toList());
                            if(currentLocations.isEmpty()){
//                                logger.info("No Location Found for This Driver !");
                                tripstatus = null;
                            } else {
                                currentLocation = currentLocations.get(0);
                                id = currentLocation.getTripId();
                                cost = currentLocation.getCurrentTripCost();
                                numOfPassengers = currentLocation.getNumberOfPassengers();
                                if(Objects.nonNull(id)){
                                    tripstatus = "onTrip";
                                }else {
                                    tripstatus = "idle";
                                }
                            }

                            driverName =  driverList.stream().filter(driver -> driver.getId().equals(device.getDriverId())).findFirst().get().getName();

                            results.add(VehicleLastDataListResponse
                                    .builder()
                                    .id(device.getId())
                                    .name(device.getName())
                                    .driverName(driverName)
                                    .lastUpdate(device.getLastupdate())
                                    .sequence_number(device.getSequence_number())
                                    .status(assistantServiceImpl.getVehicleStatus(device.getLastupdate()))
                                    .tripStatus(tripstatus)
                                    .currentCost(cost)
                                    .numOfPassengers(numOfPassengers)

                                    .build());
                        }catch (Exception | Error e){
                           logger.info(e.getLocalizedMessage());
                           throw new ApiGetException(e.getLocalizedMessage());
                        }
                        logger.info("Device id Is after : "+device.getId());
                    }
                    builder.setBody(results);
                    builder.setStatusCode(200);
                    builder.setMessage("Data Found");
                    builder.setSize(results.size());
                    builder.setSuccess(true);
                    return builder.build();
                }
                throw new ApiGetException("Error");
            }
        }
        builder.setBody(results);
        builder.setStatusCode(401);
        builder.setMessage("No Vehicles Found");
        builder.setSize(results.size());
        builder.setSuccess(false);
        return builder.build();


    }

}
