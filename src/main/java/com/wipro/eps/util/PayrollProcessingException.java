package com.wipro.eps.util;

public class PayrollProcessingException extends Exception{
    @Override
    public String toString(){
        return "Can't process Payroll";
    }

}
