package com.Fuinco.Fuinco.Monitoring.exception;
/**
 * @author Assem
 */
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}