package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest_Lab3 {
    Employee testEmployee1;
    Employee testEmployee2;
    EmployeeMock employeeMock;


    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();

        // Employee testEmployee1 = new Employee("Cornel", "Testescu", "1121225000001", DidacticFunction.ASISTENT, 7500d);
        testEmployee1 = new Employee();
        testEmployee1.setLastName("Testescu");
        testEmployee1.setFirstName("Cornel");
        testEmployee1.setCnp("1121225000001");
        testEmployee1.setFunction(DidacticFunction.ASISTENT);
        testEmployee1.setSalary(7500d);

        // Employee testEmployee2 = new Employee("Mihai", "Mihaescu", "1501225000002", DidacticFunction.ASISTENT, 3500d);
        testEmployee2 = new Employee();
        testEmployee2.setLastName("Mihaescu");
        testEmployee2.setFirstName("Mihai");
        testEmployee2.setCnp("1501225000002");
        testEmployee2.setFunction(DidacticFunction.ASISTENT);
        testEmployee2.setSalary(3500d);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TC01_modifyEmployeeFunction() {
        // create null test employee
        Employee nullEmployee = new Employee();
        nullEmployee = null;
        // check that the element is not added
        List<Employee> initialList = employeeMock.getEmployeeList();
        employeeMock.modifyEmployeeFunction(nullEmployee, DidacticFunction.CONFERENTIAR);
        List<Employee> modifiedlList = employeeMock.getEmployeeList();
        // check result
        assertTrue(initialList.equals(modifiedlList));
    }

    @Test
    void TC02_modifyEmployeeFunction() {
        // add new employee to list
        employeeMock.addEmployee(testEmployee1);
        // call test function
        employeeMock.modifyEmployeeFunction(testEmployee1, DidacticFunction.CONFERENTIAR);
        // check result
        int lastItem = employeeMock.getEmployeeList().size()-1;
        assertTrue(employeeMock.getEmployeeList().get(lastItem).getFunction().equals(DidacticFunction.CONFERENTIAR));
    }

    @Test
    void TC03_modifyEmployeeFunction() {
        // call test function
        employeeMock.modifyEmployeeFunction(testEmployee1, DidacticFunction.LECTURER);
        // check result
        int lastItem = employeeMock.getEmployeeList().size()-1;
        assertTrue(employeeMock.getEmployeeList().get(lastItem).getFunction().equals(DidacticFunction.LECTURER));
    }

    @Test
    void TC04_modifyEmployeeFunction() {
        // add new employee to list
        employeeMock.addEmployee(testEmployee2);
        // call test function
        employeeMock.modifyEmployeeFunction(testEmployee2, DidacticFunction.LECTURER);
        // check result
        int lastItem = employeeMock.getEmployeeList().size()-1;
        assertTrue(employeeMock.getEmployeeList().get(lastItem).getFunction().equals(DidacticFunction.LECTURER));
    }

    @Test
    void TC05_modifyEmployeeFunction() {
        // call test function
        employeeMock.modifyEmployeeFunction(testEmployee1, DidacticFunction.TEACHER);
        // check result
        int lastItem = employeeMock.getEmployeeList().size()-1;
        assertTrue(employeeMock.getEmployeeList().get(lastItem).getFunction().equals(DidacticFunction.TEACHER));
    }

}