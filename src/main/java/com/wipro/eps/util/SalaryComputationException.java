package com.wipro.eps.util;

public class SalaryComputationException extends Exception {

    public SalaryComputationException() {
        super("Can't compute salary");
    }

    public SalaryComputationException(String message) {
        super(message);
    }
}
