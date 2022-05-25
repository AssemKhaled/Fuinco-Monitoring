package com.Fuinco.Fuinco.Monitoring.services;

import com.Fuinco.Fuinco.Monitoring.entities.User;

import java.util.List;
/**
 * @author Assem
 */
public interface UserService {
    User findById(Long userId);
    void resetChildernArray();
    List<User> getActiveAndInactiveChildern(Long userId);

    Boolean checkUserHasPermission(Long userId,String module,String functionality);

}
