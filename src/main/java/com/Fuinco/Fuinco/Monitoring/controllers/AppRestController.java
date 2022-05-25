//package com.Fuinco.Fuinco.Monitoring.controllers;
//
//import com.Fuinco.Fuinco.Monitoring.config.security.MyUserDetailsService;
//import com.Fuinco.Fuinco.Monitoring.config.security.JwtUtil;
//import com.Fuinco.Fuinco.Monitoring.dto.requests.loginRequest;
//import com.Fuinco.Fuinco.Monitoring.dto.response.loginResponse;
//import com.Fuinco.Fuinco.Monitoring.services.Impl.AppService;
//import com.Fuinco.Fuinco.Monitoring.services.Impl.AppServiceImp;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequiredArgsConstructor
//@RequestMapping(path = "/app")
//public class AppRestController {
//    AppServiceImp appServiceImp;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//    @GetMapping(value ="/info")
//    public String info(){
//        return "hello";
//    }
//
//    @PostMapping(value = "/login")
//    public ResponseEntity<?>loginApp(@RequestBody loginRequest loginrequest)throws Exception{
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginrequest.getEmail(), loginrequest.getPassword())
//            );
//        }
//        catch(BadCredentialsException e){
//            throw new Exception("Incorrect email or password");
//        }
//        final UserDetails userDetails= userDetailsService.loadUserByUsername(loginrequest.getEmail());
//        final String jwt=jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new loginResponse(jwt));
//    }
//
//
//
//
//}
