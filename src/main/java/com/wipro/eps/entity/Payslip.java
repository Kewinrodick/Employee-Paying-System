package com.wipro.eps.entity;

public class Payslip {
    private String payslipId;
    private String employeeId;
    private String month;
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;

    public String getPayslipId() {
        return payslipId;
    }

    public void setPayslipId(String payslipId) {
        this.payslipId = payslipId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Payslip{" +
                "payslipId='" + payslipId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", month='" + month + '\'' +
                ", grossSalary=" + grossSalary +
                ", totalDeductions=" + totalDeductions +
                ", netSalary=" + netSalary +
                '}';
    }
}
