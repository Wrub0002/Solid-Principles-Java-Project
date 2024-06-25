/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Calendar;
import java.util.Date;

/**
 * Implements the ContractEmployeeService interface.
 * This class is responsible for managing contract-specific details.
 */
public class ContractEmployeeImpl implements ContractEmployeeService {
    
    /**
    * Calculates total compensation for a contract employee.
    * @param employee The employee whose compensation needs to be calculated.
    * @return Total compensation as a double.
    */
    @Override
    public double calculateTotalCompensation(Employee employee) {
            return employee.getSalary();
    }
    /**
    * Calculates the renewal date for a contract employee's contract.
    * @param employee The employee whose contract renewal date is being calculated.
    * @return The date of renewal.
    */
     @Override
    public Date renewalDate(Employee employee) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 
        calendar.add(Calendar.YEAR, 1);
        Date renewalDate = calendar.getTime();
        employee.setRenewalDate(renewalDate);
        return renewalDate;
    }
}
