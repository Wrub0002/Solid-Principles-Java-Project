package com.algonquin.cst8288.assignment1.controller;


import java.io.IOException;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;

            /**
             * This class is responsible for processing and managing employee data.
             * It validates the employee information, calculates various employment metrics, and stores the data persistently.
             */
        public class EmployeeController {
            private final EmployeeValidator validator;
            private final EmployeeStorage storage;

            public EmployeeController(EmployeeValidator validator, EmployeeStorage storage) {
            this.validator = validator;
            this.storage = storage;
    }
            /**
            * Processes the employee data by validating and then storing it.
            * Calculates compensation, contributions, and other employment details.
            *
            * @param employee the employee to be processed
            * @return a string indicating whether the processing was successful or failed 
            * @throws IOException if an error occurs during data storage
            */
		
	public String processEmployee(Employee employee) throws IOException {
		  // Validate employee data
            if (!validator.isValidEmployee(employee)) {
            return "FAILED";
        }
            storage.saveEmployee(employee, "employee_data.txt");
            return "SUCCESS";
    }
}