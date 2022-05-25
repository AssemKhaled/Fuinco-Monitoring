package com.Fuinco.Fuinco.Monitoring.config.security;

import com.Fuinco.Fuinco.Monitoring.entities.User;
import com.Fuinco.Fuinco.Monitoring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class MyUserDetailsService  {
//implements UserDetailsService
    //    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
////        Optional<User> user1=userRepository.findById(2L);
//        if (user==null){
//            throw new UsernameNotFoundException("User Not Found");
//        } else if (user.getAccountType()==1) {
//            System.out.println(user.getEmail());
//         return user;
//        }
//    return null;
//    }
}
