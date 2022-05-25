package com.Fuinco.Fuinco.Monitoring.helper.Impl;

import com.Fuinco.Fuinco.Monitoring.entities.User;
import com.Fuinco.Fuinco.Monitoring.exception.ApiGetException;
import com.Fuinco.Fuinco.Monitoring.helper.AssistantService;
import com.Fuinco.Fuinco.Monitoring.repositories.DeviceRepository;
import com.Fuinco.Fuinco.Monitoring.services.Impl.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Assem
 */
@Service
public class AssistantServiceImpl implements AssistantService {
    private static final Log logger = LogFactory.getLog(AssistantServiceImpl.class);
    private final UserServiceImpl userServiceImpl;
    private final DeviceRepository deviceRepository;

    public AssistantServiceImpl(UserServiceImpl userServiceImpl, DeviceRepository deviceRepository) {
        this.userServiceImpl = userServiceImpl;
        this.deviceRepository = deviceRepository;
    }



    @Override
    public List<Long> getChildrenOfUser(Long userId) {

        List<Long> userIds = new ArrayList<>();
        User user = userServiceImpl.findById(userId);
        userServiceImpl.resetChildernArray();

        if (userId != 0) {
            if (user == null) {
                throw new ApiGetException("This User is not Found");
            }
            if (user.getDelete_date() != null) {
                throw new ApiGetException("This User Was Delete at : " + user.getDelete_date());
            }
            if (user.getAccountType().equals(4)) {
                userIds.add(userId);
            } else {
                List<User> childrenUsers = userServiceImpl.getActiveAndInactiveChildern(userId);
                if (childrenUsers.isEmpty()) {
                    userIds.add(userId);
                } else {
                    userIds.add(userId);
                    for (User object : childrenUsers) {
                        userIds.add(object.getId());
                    }
                }
            }
            return userIds;
        }
       throw new ApiGetException ("User Id is Invalid");
    }

    @Override
    public String getVehicleStatus(String  lastUpdate) {

//        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        inputFormat1.setLenient(false);
//        inputFormat.setLenient(false);
//        Date dateFrom;
//        try {
//            dateFrom = inputFormat.parse(lastUpdate);
//        }
//        catch (ParseException e){
//            try {
//                dateFrom = inputFormat1.parse(lastUpdate);
//
//            } catch (ParseException e2) {
//                dateFrom=null;
//            }
//
//        }
        if (lastUpdate != null) {
//            logger.info("getVehicleStatus( "+lastUpdate+" ) Started !");
//            System.out.println("ehhhh");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false);
            formatter2.setLenient(false);
            Date date = new Date();


            try {
                date= formatter.parse(lastUpdate);
                logger.info("Date Format First Block : "+date);
            } catch (ParseException e2) {

                logger.error("Date Format failure : "+e2.getLocalizedMessage());
                e2.printStackTrace();
            }




            Date now = new Date();
            long minutes;
            minutes = getDateDiffByMin (date, now, TimeUnit.MINUTES);
            logger.info("Duration by minutes : "+minutes);
            if(minutes <= 3) {
//                logger.info("Device Status : Online");
                return "online";
            }
            else if(minutes >= 8) {
//                logger.info("Device Status : Offline");
                return "offline";
            }else if(minutes<8){
//                logger.info("Device Status : Out Of Network");
                return "out Of Network";
            }else {
//                logger.info("Device Status : Unknown 1");
                return "unknown Status";
            }
        }
//        logger.info("Device Status : Unknown 1");
        return "unknown Status";
        }

    @Override
    public String driverStatus(String tripId) {
        if(Objects.nonNull(tripId)){
            return "onTrip";
        }else {
            return "idle";
        }
    }

    public static long getDateDiffByMin(Date date1, Date date2, TimeUnit timeUnit) {
        return timeUnit.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
    }

}


