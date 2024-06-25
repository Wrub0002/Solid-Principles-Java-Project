/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

/**
 * Implements the PermanentEmployeeService interface.
 * This class handles compensation calculations specific to permanent employees.
 */
public class PermanentEmployeeImpl implements PermanentEmployeeService {
    /**
    * Calculates total compensation for a permanent employee.
    * @param employee The employee object containing salary and other relevant details.
    * @return Total compensation as a double value.
    */
    @Override
        public double calculateTotalCompensation(Employee employee) {
            double salary = employee.getSalary();
            double bonus = employee.getBonus();
            return salary + bonus;
    }
    /**
    * Calculates the bonus for a permanent employee based on their salary and years of service.
    * @param employee The employee object to calculate the bonus for.
    * @return Bonus amount as a double.
    */
    @Override
        public double calculateBonus(Employee employee) {
            return employee.getSalary() * 0.025 * employee.getNumberOfServiceYear();
    }
    /**
    * Calculates the pension contribution for a permanent employee.
    * @param employee The employee object to calculate the pension contribution for.
    * @return Pension contribution as a double.
    */
    @Override
        public double pensionContribution(Employee employee){
            return employee.getSalary() * 0.01;
    }
}
