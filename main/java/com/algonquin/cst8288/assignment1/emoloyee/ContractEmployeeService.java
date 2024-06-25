/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;

    /**
    * Interface for defining the services specific to contract employees.
    */
public interface ContractEmployeeService extends EmployeeService {
   
    public Date renewalDate(Employee employee);
    
}
