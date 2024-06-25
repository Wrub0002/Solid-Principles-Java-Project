package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;

    /**
    * General interface for employee services.
    * This defines the basic functionality for calculating the total compensation
    * of an employee.
    */
    public interface EmployeeService {
   
	public double calculateTotalCompensation(Employee employee);
	
}
