package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest_Lab2 {
    Employee testEmployee;
    EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        testEmployee = new Employee();
        testEmployee.setLastName("Popescu");
        testEmployee.setFirstName("Ion");
        testEmployee.setCnp("1671225100307");
        testEmployee.setFunction(DidacticFunction.LECTURER);
        testEmployee.setSalary(12000.0);

        employeeMock = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TC1_addEmployee() {
        boolean addedEmployee = employeeMock.addEmployee(testEmployee);
        //System.out.println(addedEmployee);
        assertTrue(addedEmployee);

        // Initial attempt
        //try{
            //boolean addedEmployee = employeeMock.addEmployee(testEmployee);
            //System.out.println(addedEmployee);
            //assertTrue(addedEmployee);
        //} catch (Exception e){
            //assert (false);
        //}
    }

    @Test
    void TC2_addEmployee() {
        testEmployee.setLastName("Po");
        boolean addedEmployee = employeeMock.addEmployee(testEmployee);
        assertFalse(addedEmployee);
    }

    @Test
    void TC3_addEmployee() {
        testEmployee.setLastName("Popescu");
        testEmployee.setCnp("167122510030");
        boolean addedEmployee = employeeMock.addEmployee(testEmployee);
        assertFalse(addedEmployee);
    }

    @Test
    void TC4_addEmployee() {
        testEmployee.setCnp("16712251003070");
        boolean addedEmployee = employeeMock.addEmployee(testEmployee);
        assertFalse(addedEmployee);
    }

    @Test
    void TC5_addEmployee() {
        testEmployee.setCnp("1671225100307");
        testEmployee.setSalary(0d);
        boolean addedEmployee = employeeMock.addEmployee(testEmployee);
        assertFalse(addedEmployee);
    }

}