package com.wipro.eps.util;

public class InvalidEmployeeException extends Exception{
    @Override
    public String toString() {
        return "Employee not valid";
    }
}
