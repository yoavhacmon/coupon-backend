package com.jb.coupon3.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * This class constructs a new exception with the specified detail message
 * {@link ClientAdvice}
 */
public class ExceptionDetails {
    private String error;
    private String details;
}
