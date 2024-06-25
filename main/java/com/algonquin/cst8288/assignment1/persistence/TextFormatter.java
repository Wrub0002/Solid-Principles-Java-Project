/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import java.io.IOException;

/**
* Provides functionality to format an Employee object into a string of key-value pairs.
*/
public class TextFormatter implements Formatter {
    
    /**
    * Formats the provided Employee object into a string containing key-value pairs of employee attributes.
    * If the employee's renewalDate is not null, it includes that in the output.
    * Throws IllegalArgumentException if the employee object is null to prevent further processing errors.
    *
    * @param employee The Employee object to be formatted.
    * @return A string representation of the Employee object in key-value pair format.
    * @throws IllegalArgumentException If the provided Employee object is null.
    * @throws IOException If any I/O errors occur during processing.
    */
    @Override
    public String format(Employee employee) throws IOException {
        if (employee == null) {
            throw new IllegalArgumentException("employee cannot be null");
        }
         StringBuilder builder = new StringBuilder();
        builder.append("name=").append(employee.getName()).append(", ");
        builder.append("email=").append(employee.getEmail()).append(", ");
        builder.append("address=").append(employee.getAddress()).append(", ");
        builder.append("salary=").append(employee.getSalary()).append(", ");
        builder.append("numberOfServiceYear=").append(employee.getNumberOfServiceYear()).append(", ");
        builder.append("bonus=").append(employee.getBonus()).append(", ");
        builder.append("totalCompensation=").append(employee.getTotalCompensation());

        if (employee.getRenewalDate() != null) {
            builder.append(", renewalDate=").append(employee.getRenewalDate());
        }

        return builder.toString();
    }
}
