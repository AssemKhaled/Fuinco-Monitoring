package com.Fuinco.Fuinco.Monitoring.services.Impl;

import com.Fuinco.Fuinco.Monitoring.entities.User;
import com.Fuinco.Fuinco.Monitoring.entities.UserRole;
import com.Fuinco.Fuinco.Monitoring.repositories.UserRepository;
import com.Fuinco.Fuinco.Monitoring.repositories.UserRoleRepository;
import com.Fuinco.Fuinco.Monitoring.services.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author Assem
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public User findById(Long userId) {
        // TODUserO Auto-generated method stub
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        if(!optionalUser.isPresent()) {
            return null;
        }
        if(user.getDelete_date() != null) {

            return null;
        }
        else
        {
            return user;
        }

    }

    @Override
    public void resetChildernArray() {
        List<User> childernUsers = new ArrayList<>();
        childernUsers = new ArrayList<>();
    }

    @Override
    public List<User> getActiveAndInactiveChildern(Long userId) {

        List<User> childernUsers = new ArrayList<>();

        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        if(user != null) {
            if(user.getAccountType() == 1) {
                List<User>childrenReturned1 = userRepository.getActiveAndInactiveChildrenOfUser(userId);
                if(!childrenReturned1.isEmpty()) {
                    for(User object1 : childrenReturned1) {
                        childernUsers.add(object1);

                        if(object1.getAccountType() == 2) {
                            List<User>childrenReturned2 = userRepository.getActiveAndInactiveChildrenOfUser(object1.getId());
                            if(!childrenReturned2.isEmpty()) {
                                for(User object2 : childrenReturned2) {
                                    childernUsers.add(object2);

                                    if(object2.getAccountType() == 3) {
                                        List<User>childrenReturned3 = userRepository.getActiveAndInactiveChildrenOfUser(object2.getId());
                                        if(!childrenReturned3.isEmpty()) {
                                            for(User object3 : childrenReturned3) {
                                                childernUsers.add(object3);

                                            }
                                        }
                                    }
                                }
                            }


                        }
                    }
                }
            }
            if(user.getAccountType() == 2) {
                List<User>childrenReturned1 = userRepository.getActiveAndInactiveChildrenOfUser(userId);
                if(!childrenReturned1.isEmpty()) {
                    for(User object1 : childrenReturned1) {
                        childernUsers.add(object1);

                        if(object1.getAccountType() == 3) {
                            List<User>childrenReturned2 = userRepository.getActiveAndInactiveChildrenOfUser(object1.getId());
                            if(!childrenReturned2.isEmpty()) {
                                for(User object2 : childrenReturned2) {
                                    childernUsers.add(object2);

                                }
                            }
                        }
                    }
                }
            }
            if(user.getAccountType() == 3) {
                List<User>childrenReturned1 = userRepository.getActiveAndInactiveChildrenOfUser(userId);
                if(!childrenReturned1.isEmpty()) {
                    for(User object1 : childrenReturned1) {
                        childernUsers.add(object1);
                    }
                }
            }
        }

        return childernUsers;
    }

    @Override
    public Boolean checkUserHasPermission(Long userId, String module, String functionality) {
        // TODO Auto-generated method stub
        if(userId == 0 || module == "" || module == null || functionality == "" || functionality == null) {
            return false;
        }
        List<UserRole> roles = userRoleRepository.getUserRole(userId);
        if(roles.isEmpty()) {
            return false;
        }else {
            UserRole role = roles.get(0);

            JSONObject permissions = new JSONObject(role.getPermissions());
            if(permissions.has("permissions")) {
                JSONArray the_json_array = permissions.getJSONArray("permissions");

                for(Object object : the_json_array) {

                    JSONObject permissionObject = new JSONObject(object.toString());

                    if( permissionObject.has("name")) {
                        if(permissionObject.getString("name").equals(module)) {

                            JSONObject serviceFunctionalities= permissionObject.getJSONObject("functionality");

                            if(serviceFunctionalities.has(functionality)) {

                                if(serviceFunctionalities.getBoolean(functionality)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;

            }else {
                return false;
            }
        }
    }

}
