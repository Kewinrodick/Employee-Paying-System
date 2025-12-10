package com.wipro.eps.main;

import java.util.ArrayList;
import com.wipro.eps.entity.Employee;
import com.wipro.eps.entity.PayrollRule;
import com.wipro.eps.entity.Payslip;
import com.wipro.eps.service.PayrollService;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setEmployeeId("E001");
        e1.setName("Rahul Kumar");
        e1.setDesignation("Software Engineer");
        e1.setGrade("A1");
        e1.setBasicSalary(40000);
        e1.setHra(10000);
        e1.setOtherAllowance(5000);

        Employee e2 = new Employee();
        e2.setEmployeeId("E002");
        e2.setName("Priya Sharma");
        e2.setDesignation("HR Executive");
        e2.setGrade("B1");
        e2.setBasicSalary(30000);
        e2.setHra(8000);
        e2.setOtherAllowance(4000);

        employees.add(e1);
        employees.add(e2);

        PayrollRule rule = new PayrollRule();
        rule.setTaxPercentage(10.0);
        rule.setPfPercentage(12.0);
        rule.setOtherDeductionsPercentage(2.0);

        PayrollService service = new PayrollService(employees, rule);
        try {
            Payslip p = service.generatePayslip("E001", "APRIL-2024");
            System.out.println("Payslip Generated Successfully!");
            System.out.println("Net Salary: " + p.getNetSalary());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}