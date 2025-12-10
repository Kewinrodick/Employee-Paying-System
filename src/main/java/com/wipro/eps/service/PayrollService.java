package com.wipro.eps.service;

import com.wipro.eps.entity.Employee;
import com.wipro.eps.entity.PayrollRule;
import com.wipro.eps.entity.Payslip;
import com.wipro.eps.util.InvalidEmployeeException;
import com.wipro.eps.util.SalaryComputationException;

import java.util.ArrayList;

public class PayrollService {

    private ArrayList<Employee> employees;
    private PayrollRule payrollRule;

    public PayrollService(ArrayList<Employee> employees, PayrollRule payrollRule) {
            this.employees = employees;
            this.payrollRule = payrollRule;
    }
    public boolean validateEmployee(String employeeId) throws InvalidEmployeeException{
            for (Employee employee : employees) {
                if (employee.getEmployeeId().equals(employeeId)) {
                    return true;
                }
            }
            throw new InvalidEmployeeException("Employee Not Found");
    }
    public Employee findEmployee(String employeeId) throws InvalidEmployeeException{
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        throw new InvalidEmployeeException("Employee Not Found");
    }
    public double calculateGrossSalary(Employee employee) throws SalaryComputationException {
        try{
            this.validateEmployee(employee.getEmployeeId());
        }catch(InvalidEmployeeException e){
            throw new SalaryComputationException();
        }
        double base = employee.getBasicSalary();
        double hra = employee.getHra();
        double allowance = employee.getOtherAllowance();
        
        if(base > 0 && hra > 0 && allowance > 0){
            return base + hra + allowance;
        }else{
            throw new SalaryComputationException("Exception in calculating gross");
        }
    }
    public double calculateTotalDeductions(double gross, Employee employee) throws SalaryComputationException{
        try{
            this.validateEmployee(employee.getEmployeeId());
        }catch(InvalidEmployeeException e){
            throw new SalaryComputationException();
        }
        if (gross < 0) {
            throw new SalaryComputationException();
        }
        double tax = payrollRule.getTaxPercentage();
        double pf = payrollRule.getPfPercentage();
        double other = payrollRule.getOtherDeductionsPercentage();

        if(tax <0.0 || pf <0.0 || other <0.0){
            throw new SalaryComputationException();
        }
        if(tax >=100.0 || pf >=100.0 || other >=100.0){
            throw new SalaryComputationException();
        }
        double total = (gross * tax / 100) + (gross * pf / 100) + (gross * other / 100);
        if(total > gross){
            throw new SalaryComputationException("Exception in calculating total");
        }
        return total;
    }
    public Payslip generatePayslip(String employeeId, String month) throws Exception{
            Employee employee = findEmployee(employeeId);

            double gross = calculateGrossSalary(employee);
            double deductions = calculateTotalDeductions(gross, employee);

            Payslip payslip = new Payslip();
            payslip.setPayslipId("P"+employeeId);
            payslip.setEmployeeId(employeeId);
            payslip.setMonth(month);
            payslip.setGrossSalary(gross);
            payslip.setTotalDeductions(deductions);
            payslip.setNetSalary(gross - deductions);
            return payslip;

    }


    public ArrayList<Payslip> processMonthlyPayroll(ArrayList<String> employeeIds, String month) throws Exception {
        ArrayList<Payslip> payslips = new ArrayList<>();
        for(String employeeId : employeeIds){
            payslips.add(generatePayslip(employeeId,month));
        }
        return payslips;
    }
}
