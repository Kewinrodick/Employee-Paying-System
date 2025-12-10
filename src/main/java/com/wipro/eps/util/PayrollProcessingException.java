package com.wipro.eps.util;

public class PayrollProcessingException extends Exception{
    public PayrollProcessingException(String message) {
        super(message);
    }

    public PayrollProcessingException() {
        super("Payroll Processing Exception");
    }
}
