package com.jb.coupon3.exceptions;
/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

/**
 * this class is to customize certain exceptions that might occur during running the application, server side.
 */
public class CustomExceptions extends Exception{

    /**
     * c'tor to handle custom exceptions
     * @param message defined in {@link OptionalExceptionMessages}
     */
    public CustomExceptions(OptionalExceptionMessages message) {
        super(message.getMessage());
    }
}
