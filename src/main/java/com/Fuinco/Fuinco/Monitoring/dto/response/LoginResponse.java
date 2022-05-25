package com.Fuinco.Fuinco.Monitoring.dto.response;

public class LoginResponse {
    private final String jwt;

    public LoginResponse(String jwt){
        this.jwt=jwt;
    }
    public String getJwt()
    {
        return jwt;
    }
}
