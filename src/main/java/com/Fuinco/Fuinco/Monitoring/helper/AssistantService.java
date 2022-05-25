package com.Fuinco.Fuinco.Monitoring.helper;

import java.util.List;
/**
 * @author Assem
 */
public interface AssistantService {

   List<Long> getChildrenOfUser(Long userId);
   String getVehicleStatus(String lastUpdate);
   String driverStatus(String tripId);
}
