/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class provides unit tests for the PermanentEmployeeImpl class.
 * It tests methods related to compensation calculations like total compensation,
 * bonus, and pension contributions for permanent employees.
 */
public class PermanentEmployeeImplTest {
    
    private PermanentEmployeeImpl employeeService;
    private Employee employee;
    
    /**
     * Sets up the test environment before each test method.
     * Initializes a mock employee object with a fixed salary and years of service.
     */
    @Before
    public void setUp() {
        employeeService = new PermanentEmployeeImpl();
        employee = new Employee() {
            private final double salary = 100000;  
            private final int yearsOfService = 5; 

            @Override
            public double getSalary() {
                return salary;
            }

            @Override
            public double getBonus() {
                return 5000; 
            }

            @Override
            public int getNumberOfServiceYear() {
                return yearsOfService;
            }
        };
    }
    /**
     * Tests the calculation of total compensation, which includes salary and bonus.
     */
    @Test
    public void testCalculateTotalCompensation() {
        double expected = 105000;  // salary + bonus
        assertEquals(expected, employeeService.calculateTotalCompensation(employee), 0.001);
    }
    /**
     * Tests the calculation of bonus based on the salary and years of service.
     */
    @Test
    public void testCalculateBonus() {
        double expected = 100000 * 0.025 * 5;  // salary * 2.5% * years of service
        assertEquals(expected, employeeService.calculateBonus(employee), 0.001);
    }
    /**
     * Tests the calculation of pension contribution.
     */
    @Test
    public void testPensionContribution() {
        double expected = 100000 * 0.01;  // 1% of salary
        assertEquals(expected, employeeService.pensionContribution(employee), 0.001);
    }
}
