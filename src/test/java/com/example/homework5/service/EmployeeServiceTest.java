package com.example.homework5.service;

import com.example.homework5.employee.Employee;
import com.example.homework5.exception.EmployeeAlreadyAddedException;
import com.example.homework5.exception.EmployeeNotFoundException;
import com.example.homework5.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private EmployeeServiceInterface employeeService = new EmployeeService();

    @Test
    public void shouldReturnEmployeeWhenAddNotExists() {
        employeeService.add("Ivan", "Ivanov", 100000, 3);
        Employee employee = employeeService.get("Ivan", "Ivanov");
        Employee employeeExtends = new Employee("Ivan", "Ivanov", 100000, 3);
        assertEquals(employeeExtends, employee);
    }

    @Test
    public void shouldReturnEmployeeStorageIsFullExceptionAtAdd() {
        employeeService.add("Sergey1", "Sergeev", 85000, 4);
        employeeService.add("Sergey2", "Sergeev", 85000, 4);
        employeeService.add("Sergey3", "Sergeev", 85000, 4);
        employeeService.add("Sergey4", "Sergeev", 85000, 4);
        employeeService.add("Sergey5", "Sergeev", 85000, 4);
        employeeService.add("Sergey6", "Sergeev", 85000, 4);
        employeeService.add("Sergey7", "Sergeev", 85000, 4);
        employeeService.add("Sergey8", "Sergeev", 85000, 4);
        employeeService.add("Sergey9", "Sergeev", 85000, 4);
        employeeService.add("Sergey10", "Sergeev", 85000, 4);
        assertThrows(EmployeeStorageIsFullException.class, () ->
                employeeService.add("Sergey11", "Sergeev", 85000, 4));
    }

    @Test
    public void shouldReturnEmployeeAlreadyAddedExceptionAtAdd() {
        employeeService.add("Ivan", "Ivanov", 100000, 3);
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.add("Ivan", "Ivanov", 100000, 3));
    }

    @Test
    public void shouldReturnEmployeeWhenRemoveExists() {
        employeeService.add("Ivan", "Ivanov", 100000, 3);
        Employee employee = employeeService.remove("Ivan", "Ivanov");
        Employee expectedEmployee = new Employee("Ivan", "Ivanov", 100000, 3);
        assertEquals(expectedEmployee, employee);
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionAtRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionAtGet() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.get("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnEmployeesAtGetAll() {
        employeeService.add("Ivan1", "Ivanov", 100000, 3);
        employeeService.add("Ivan2", "Ivanov", 100000, 3);
        employeeService.add("Ivan3", "Ivanov", 100000, 3);
        Collection<Employee> employees = new HashSet<>(List.of(
                new Employee("Ivan1", "Ivanov", 100000, 3),
                new Employee("Ivan2", "Ivanov", 100000, 3),
                new Employee("Ivan3", "Ivanov", 100000, 3)));
        assertTrue(employees.containsAll(employeeService.getAll()));
    }

}
