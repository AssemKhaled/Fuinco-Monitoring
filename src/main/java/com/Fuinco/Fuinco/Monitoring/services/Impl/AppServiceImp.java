//package com.Fuinco.Fuinco.Monitoring.services.Impl;
//
//import com.Fuinco.Fuinco.Monitoring.entities.User;
//import com.Fuinco.Fuinco.Monitoring.repositories.UserRepository;
//import com.Fuinco.Fuinco.Monitoring.services.AppService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.lang.model.util.SimpleAnnotationValueVisitor6;
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//@Transactional
//@Slf4j
//@RequiredArgsConstructor
//public class AppServiceImp implements AppService, UserDetailsService {
//    private static final Log logger = LogFactory.getLog(AppServiceImp.class);
//    @Autowired
//    private UserRepository userRepository;
////    @Autowired
//    private final PasswordEncoder passwordEncoder;
//    @Override
//    public ResponseEntity<?> loginApp(String authorization) {
//        logger.info("************************ Login STARTED ***************************");
//
//
//        return null;
//    }
//    public User saveUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user=userRepository.findByEmail(email);
//
//        if (user==null){
//            log.error("User not found in the database");
//            throw new UsernameNotFoundException("Email not Found in the database");
//        }else {
//            log.info("User not Found in the database: {}",email);
//        }
//        Collection<SimpleGrantedAuthority>authorities=new ArrayList<>();
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
//    }
//}
