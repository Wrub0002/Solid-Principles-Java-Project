/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;

/**
 * Tests for ContractEmployeeImpl focusing on compensation calculations and contract renewal functionalities.
 * It verifies methods related to the total compensation and the setting and calculation of renewal dates for contract employees.
 */
public class ContractEmployeeImplTest {
    
    private ContractEmployeeImpl contractEmployeeService;
    private Employee employee;

    /**
     * Sets up objects before each test.
     * This includes initializing the service and a mock employee with preset salary and renewal date functionalities.
     */
    @Before
    public void setUp() {
        contractEmployeeService = new ContractEmployeeImpl();
        employee = new Employee() {
            private final double salary = 50000;
            private Date renewalDate;

            @Override
            public double getSalary() {
                return salary;
            }

            @Override
            public void setRenewalDate(Date date) {
                this.renewalDate = date;
            }

            @Override
            public Date getRenewalDate() {
                return this.renewalDate;
            }
        };
    }
    /**
     * Tests the calculation of total compensation for a contract employee.
     * Expected to be equivalent to the employee's salary as there are no additional compensations.
     */
    @Test
    public void testCalculateTotalCompensation() {
        double expected = 50000;
        double result = contractEmployeeService.calculateTotalCompensation(employee);
        assertEquals("Total compensation should match the employee's salary", expected, result, 0.001);
    }
    /**
     * Tests the calculation of the contract renewal date for an employee.
     */

   @Test
public void testRenewalDate() {
    // This test calculates the expected renewal date by adding one year to today's date
    Calendar expectedCalendar = Calendar.getInstance();
    expectedCalendar.add(Calendar.YEAR, 1);
    expectedCalendar.set(Calendar.HOUR_OF_DAY, 0);
    expectedCalendar.set(Calendar.MINUTE, 0);
    expectedCalendar.set(Calendar.SECOND, 0);
    expectedCalendar.set(Calendar.MILLISECOND, 0);

    Date result = contractEmployeeService.renewalDate(employee);
    
    Calendar resultCalendar = Calendar.getInstance();
    resultCalendar.setTime(result);
    resultCalendar.set(Calendar.HOUR_OF_DAY, 0);
    resultCalendar.set(Calendar.MINUTE, 0);
    resultCalendar.set(Calendar.SECOND, 0);
    resultCalendar.set(Calendar.MILLISECOND, 0);

    assertEquals("Renewal date should be one year from today, ignoring time of day", expectedCalendar.getTime(), resultCalendar.getTime());
    }
}