package com.example.homework5.service;

import com.example.homework5.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class DepartmentServiceTest {
    private DepartmentServiceInterface departmentService;

    @BeforeEach
    public void setUp(){
        EmployeeService employeeService = Mockito.mock(EmployeeService.class);
        Mockito.when(employeeService.getAll()).thenReturn(employeeList());
        departmentService = new DepartmentService(employeeService);
    }

    private List<Employee> employeeList(){
        return List.of(
                new Employee("Ivan", "Ivanov", 100000,3),
                new Employee("Sergey", "Sergeev", 95000, 2),
                new Employee("Petr", "Petrov", 75000, 3));
    }

    @Test
    public void maxSalaryByDepartmentTest(){
        Employee employee = departmentService.maxSalaryByDepartment(3);
        Employee expectedEmployee = new Employee("Ivan", "Ivanov", 100000,3);
        assertEquals(expectedEmployee, employee);
    }

    @Test
    public void checkByExceptionMaxSalaryByDepartmentTest(){
        assertThrows(IllegalArgumentException.class, () -> departmentService.maxSalaryByDepartment(4));
    }

    @Test
    public void minSalaryByDepartmentTest(){
        Employee employee = departmentService.minSalaryByDepartment(3);
        Employee expectedEmployee = new Employee("Petr", "Petrov", 75000, 3);
        assertEquals(expectedEmployee, employee);
    }

    @Test
    public void checkByExceptionMinSalaryByDepartmentTest(){
        assertThrows(IllegalArgumentException.class, () -> departmentService.minSalaryByDepartment(4));
    }

    @Test
    public void printByDepartmentTest(){
        Collection<Employee> employees = departmentService.printByDepartment(3);
        Collection<Employee> expectedEmployees = new ArrayList<>(List.of(
                new Employee("Ivan", "Ivanov", 100000,3),
                new Employee("Petr", "Petrov", 75000, 3)));
        assertEquals(expectedEmployees, employees);
    }

    @Test
    public void printAllByDepartmentTest(){
        List<Employee> expectedEmployees = new ArrayList<>(List.of(
                new Employee("Sergey", "Sergeev", 95000, 2)));
        List<Employee> expectedEmployees2 = new ArrayList<>(List.of(
                new Employee("Ivan", "Ivanov", 100000,3),
                new Employee("Petr", "Petrov", 75000, 3)));
        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(2, expectedEmployees);
        expected.put(3, expectedEmployees2);
        assertEquals(expected, departmentService.printAllByDepartment());
    }

}