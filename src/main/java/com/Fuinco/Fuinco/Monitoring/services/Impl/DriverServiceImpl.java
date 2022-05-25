package com.Fuinco.Fuinco.Monitoring.services.Impl;

import com.Fuinco.Fuinco.Monitoring.dto.ApiResponse;
import com.Fuinco.Fuinco.Monitoring.dto.ApiResponseBuilder;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverListResponse;
import com.Fuinco.Fuinco.Monitoring.dto.response.DriverDetailsResponse;
import com.Fuinco.Fuinco.Monitoring.entities.Device;
import com.Fuinco.Fuinco.Monitoring.entities.Driver;
import com.Fuinco.Fuinco.Monitoring.entities.MongoDriverLocation;
import com.Fuinco.Fuinco.Monitoring.exception.ApiGetException;
import com.Fuinco.Fuinco.Monitoring.helper.Impl.AssistantServiceImpl;
import com.Fuinco.Fuinco.Monitoring.repositories.DeviceRepository;
import com.Fuinco.Fuinco.Monitoring.repositories.DriverRepository;
import com.Fuinco.Fuinco.Monitoring.repositories.MongoDriverLocationRepository;
import com.Fuinco.Fuinco.Monitoring.services.DriverService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Assem
 */
@Service
public class DriverServiceImpl implements DriverService {
    private final AssistantServiceImpl assistantServiceImpl;
    private final UserServiceImpl userServiceImpl;
    private final DeviceRepository deviceRepository;
    private final DriverRepository driverRepository;
    private final MongoDriverLocationRepository mongoDriverLocationRepository;

    private static final Log logger = LogFactory.getLog(VehicleServiceImpl.class);

    public DriverServiceImpl(AssistantServiceImpl assistantServiceImpl, UserServiceImpl userServiceImpl, DeviceRepository deviceRepository, DriverRepository driverRepository, MongoDriverLocationRepository mongoDriverLocationRepository) {
        this.assistantServiceImpl = assistantServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.deviceRepository = deviceRepository;
        this.driverRepository = driverRepository;
        this.mongoDriverLocationRepository = mongoDriverLocationRepository;
    }

    @Override
    public ApiResponse<List<DriverListResponse>> getDriversList(Long userId, String search, int offset, int size) {
        logger.info("****************** GET DRIVERS LIST STARTED ******************");
        ApiResponseBuilder<List<DriverListResponse>> builder = new ApiResponseBuilder<>();
        List<DriverListResponse> results = new ArrayList<>();
        List<Long> userIds;
        userIds = assistantServiceImpl.getChildrenOfUser(userId);
        List<Integer> ids = userIds.stream()
                .map(Long::intValue)
                .collect(Collectors.toList());
        Optional<List<Driver>> optionalDriverList;
        if (size > 0) {
            optionalDriverList = driverRepository.findAllByCompanyIdInAndDeleteDate(ids , PageRequest.of(offset,size),null);
        }else {
            optionalDriverList = driverRepository.findAllByCompanyIdInAndDeleteDate(ids ,null);
        }
        if (optionalDriverList.isPresent()) {
            List<Driver> driverList = optionalDriverList.get();
            if (search != "") {
                if (driverList.size() > 0 && Pattern.matches(".*\\S.*", search)) {
                    driverList = driverList.stream().filter(driver ->
                            driver.getName().contains(search)).collect(Collectors.toList());
                }
            }else {
                throw new ApiGetException("No Search Data Found");
            }
            List<Long> driverIds = new ArrayList<>();
            for (Driver driver : driverList) {
                driverIds.add(driver.getId());
            }
            Optional<List<Device>> optionalDeviceList = deviceRepository.findAllByDriverIdInAndDeleteDate(driverIds,null);
            if (optionalDeviceList.isPresent()) {
                List<Device> deviceList = optionalDeviceList.get();
                Optional<List<MongoDriverLocation>> optionalMongoDriverLocationList = mongoDriverLocationRepository.findTopByDriverIdIn(driverIds);
                if (optionalMongoDriverLocationList.isPresent()) {
                    List<MongoDriverLocation> mongoDriverLocationList = optionalMongoDriverLocationList.get();
                    for (Driver driver:driverList) {
                        String tripId = null; String vehicleName =null; Double currentTripCost =null;
                        Integer numOfPassengers=null; String lastLocationTime = null;
                        try {
                            MongoDriverLocation currentLocation ;
                            Device getDevice;
                            List<MongoDriverLocation> currentLocations = mongoDriverLocationList.stream().filter(mongoDriverLocation -> mongoDriverLocation.getDriverId().equals(driver.getId())).collect(Collectors.toList());
                            List<Device> getDevices = deviceList.stream().filter(device -> device.getDriverId().equals(driver.getId())).collect(Collectors.toList());
                            if (!currentLocations.isEmpty()){
                                currentLocation = currentLocations.get(0);
                                tripId = assistantServiceImpl.driverStatus(currentLocation.getTripId());
                                currentTripCost = currentLocation.getCurrentTripCost();
                                numOfPassengers = currentLocation.getNumberOfPassengers();
                                lastLocationTime = currentLocation.getLocationTime();
                            }
                            if (!getDevices.isEmpty()) {
                                getDevice = getDevices.get(0);
                                vehicleName =  getDevice.getName();
                            }

                            results.add(DriverListResponse
                                    .builder()
                                    .id(driver.getId())
                                    .name(driver.getName())
                                    .vehicleName(vehicleName)
                                    .mobileNumber(driver.getMobile_num())
                                    .status(tripId)
                                    .currentTripCost(currentTripCost)
                                    .numberOfPassengers(numOfPassengers)
                                    .lastLocationTime(lastLocationTime)
                                    .build());

                        }catch (Exception | Error e){
                            throw new ApiGetException(e.getLocalizedMessage());
                        }
                    }
                    logger.info("****************** GET DRIVERS LIST ENDED ******************");
                    builder.setBody(results);
                    builder.setStatusCode(200);
                    builder.setMessage("Data Found");
                    builder.setSize(results.size());
                    builder.setSuccess(true);
                    return builder.build();

                }
                throw new ApiGetException("No Locations Found for Drivers");
            }
            throw new ApiGetException("No Vehicles Found for Drivers");
        }
        throw new ApiGetException("No Drivers Found");
    }

    @Override
    public ApiResponse<DriverDetailsResponse> getDriverDetails(Long driverId) {
        logger.info("****************** GET DRIVER DETAILS STARTED ******************");
        ApiResponseBuilder<DriverDetailsResponse> builder = new ApiResponseBuilder<>();
        DriverDetailsResponse driverDetailsResponse;
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);

        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            driverDetailsResponse=DriverDetailsResponse
                                            .builder()
                                            .id(driver.getId())
                                            .name(driver.getName())
                                            .email(driver.getEmail())
                                            .licenseNo(driver.getLicense_no())
                                            .birthDate(driver.getBirth_date())
                                            .mobileNum(driver.getMobile_num())
                                            .activity(driver.getActivity())
                                            .photo(driver.getPhoto())
                                            .build();

            logger.info("****************** GET DRIVER DETAILS ENDED ******************");
            builder.setBody(driverDetailsResponse);
            builder.setStatusCode(200);
            builder.setMessage("Data Found");
            builder.setSize(1);
            builder.setSuccess(true);
            return builder.build();
        }
        throw new ApiGetException("Driver Not Found");
    }


}
