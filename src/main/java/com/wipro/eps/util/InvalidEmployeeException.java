package com.wipro.eps.util;

public class InvalidEmployeeException extends Exception{
    public InvalidEmployeeException(String message) {
        super(message);
    }

    public InvalidEmployeeException() {
        super("Invalid Employee");
    }
}
