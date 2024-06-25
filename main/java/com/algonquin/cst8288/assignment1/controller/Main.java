package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import java.io.IOException;



/**
 * This main class demonstrates the use of different employee implementations and storage mechanisms. The main method initializes necessary services and
 * components to manage employee data, calculate compensation, and outputs this data in JSON and plain text formats.
 * it prints the formatted output directly to the console.
 *
 * @author Leonardo Wrubleski
 * @version 1.0
 */

public class Main {
	
	/**
        * Main method which is used to execute the application.
        * It instantiates employee objects, applies business logic to calculate compensations and bonuses, and saves outputs to files as well as
        * displaying them in the console.
        * 
        * @throws IOException If there is an error in file input/output operations.
        */
	public static void main(String[] args) throws IOException {
                // creates formatter objects for JSON and text formatting
                JSONFormatter jsonFormatter = new JSONFormatter();
                TextFormatter textFormatter = new TextFormatter();
                
                // Create storage objects with dependency injection
                EmployeeStorage jsonStorage = new EmployeeStorage(jsonFormatter);
                EmployeeStorage textStorage = new EmployeeStorage(textFormatter);

                // Create a permanent employee and calculate compensation
                Employee permEmployee = new Employee();
                permEmployee.setName("Leonardo Wrubleski");
                permEmployee.setEmail("Leonardo2004Wrubleski@gmail.com");
                permEmployee.setAddress("82 Woodpark Way");
                permEmployee.setSalary(50000);
                permEmployee.setNumberOfServiceYear(5);

                // Create a contract employee and calculate compensation
                Employee contractEmployee = new Employee();
                contractEmployee.setName("Maria Graff");
                contractEmployee.setEmail("MariaGraff@Gmail.com");
                contractEmployee.setAddress("456 Elm St");
                contractEmployee.setSalary(40000);
                contractEmployee.setNumberOfServiceYear(2);
                
                // Apply services
        PermanentEmployeeImpl permService = new PermanentEmployeeImpl();
        ContractEmployeeImpl contractService = new ContractEmployeeImpl();

        // Calculate for permanent employee
        double permTotalCompensation = permService.calculateTotalCompensation(permEmployee);
        permEmployee.setTotalCompensation(permTotalCompensation);
        permEmployee.setBonus(permService.calculateBonus(permEmployee));

        // Calculate for contract employee
        double contractTotalCompensation = contractService.calculateTotalCompensation(contractEmployee);
        contractEmployee.setTotalCompensation(contractTotalCompensation);
        contractEmployee.setRenewalDate(contractService.renewalDate(contractEmployee));

        // Save and output data for permanent employee
        jsonStorage.saveEmployee(permEmployee, "json_employee_data.txt");
        textStorage.saveEmployee(permEmployee, "text_employee_data.txt");
        System.out.println(jsonFormatter.format(permEmployee));
        System.out.println(textFormatter.format(permEmployee));

        // Save and output data for contract employee
        jsonStorage.saveEmployee(contractEmployee, "json_employee_data.txt");
        textStorage.saveEmployee(contractEmployee, "text_employee_data.txt");
        System.out.println(jsonFormatter.format(contractEmployee));
        System.out.println(textFormatter.format(contractEmployee));
    }
}

	
