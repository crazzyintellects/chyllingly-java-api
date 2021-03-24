package com.restaurant.chyllingly.exception;

/**
 * Exception handler if NoSuchElementException is thrown
 *
 * @return Error message String.
 */
public class APIException extends Exception {
    public APIException(String exception) {
        super(exception);
    }
}
