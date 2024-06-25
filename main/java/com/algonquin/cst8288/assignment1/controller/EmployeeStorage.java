/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

    /**
     * This class is responsible for persisting employee data into a file.
     * It utilizes a specified formatter to convert employee data into a desired format before writing.
     */
public class EmployeeStorage {
    private final Formatter formatter;
    
    /**
     * Constructs an EmployeeStorage with a specified Formatter.
     * The formatter is used to format employee data for storage.
     *
     * @param formatter the formatter to format employee data
     */
    public EmployeeStorage(Formatter formatter) {
        this.formatter = formatter;
    }
    /**
    * Saves the formatted employee data to a specified file.
    * 
    * @param person The Employee object containing the data to be saved.
    * @param filename The name of the file where the employee data will be stored.
    * @throws IOException If an error occurs during the file writing process.
    */
    public void saveEmployee(Employee person, String filename) throws IOException {
	try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
		writer.println(formatter.format(person));
		writer.flush();
		}
        }
}
