/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.controller;



import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import java.io.*;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the EmployeeStorage class's ability to handle file operations for storing employee data.
 * It verifies the functionality of storing and possibly retrieving employee data formatted by a specified Formatter object.
 */
public class EmployeeStorageTest {
    
    private EmployeeStorage storage;
    private Employee employee;
    private File tempFile;
    private Formatter formatter;

    /**
     * Prepares shared resources before any tests are run, useful for setup that's expensive and common across tests.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Initialization of resources before any tests are run.");
    }
     /**
     * Cleans up shared resources after all tests have been run, useful for cleanup that's common to all tests.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Clean-up after all tests are complete.");
    }
    /**
     * Sets up the necessary objects before each test method is executed.
     */
    @Before
    public void setUp() throws IOException {
        // Initialize formatter and storage with formatter
        formatter = new JSONFormatter();
        storage = new EmployeeStorage(formatter);

        // Create a temporary file to use in tests
        tempFile = File.createTempFile("test_employee", ".txt");
        tempFile.deleteOnExit();

        // Set up an Employee object
        employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
    }
    /**
     * Cleans up after each test method, including deletion of the temporary file used for testing.
     */
    @After
    public void tearDown() {
                tempFile.delete();
    }

    /**
     * Tests the saveEmployee method to ensure it correctly writes the formatted data to a file.
     * Validates that the JSON formatted employee data is correctly written and readable from the file.
     */
    @Test
    public void testSaveEmployee() throws Exception {
        String filename = tempFile.getAbsolutePath();
        
        storage.saveEmployee(employee, filename);
        
        // Read the content of the file to verify correct writing
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String readContent = reader.readLine();
        reader.close();

        // Assert that the content of the file is as expected
        assertNotNull("File content should not be null", readContent);
        assertTrue("File content should contain employee data", readContent.contains("John Doe"));
    }
}