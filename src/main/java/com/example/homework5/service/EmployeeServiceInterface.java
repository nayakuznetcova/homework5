package com.example.homework5.service;

import com.example.homework5.employee.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface EmployeeServiceInterface {
    String startDisplay();

    Employee add(String firstname, String lastname, int salary, int departament);

    Employee remove(String firstname, String lastname);

    Employee get(String firstname, String lastname);

    Collection<Employee> getAll();
}
