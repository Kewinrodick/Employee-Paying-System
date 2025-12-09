package com.wipro.eps.util;

public class SalaryComputationException extends Exception{
    @Override
    public String toString() {
        return "Can't compute salary";
    }
}
