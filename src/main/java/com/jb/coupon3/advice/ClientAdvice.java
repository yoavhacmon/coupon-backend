package com.jb.coupon3.advice;

import com.jb.coupon3.exceptions.CustomExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

@RestController
@ControllerAdvice
/**
 * This class is responsible for handling client side errors in API's
 * {@link ExceptionDetails}
 */
public class ClientAdvice {
    @ExceptionHandler(value = {CustomExceptions.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    /**
     * @param Exception thrown by the API
     * @return a new detailed exception
     */
    public ExceptionDetails handleException(Exception exception){
        return new ExceptionDetails("error", exception.getMessage());
    }
}
