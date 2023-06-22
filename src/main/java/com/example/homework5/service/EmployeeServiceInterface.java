package com.example.homework5.service;

import com.example.homework5.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeServiceInterface {
    String startDisplay();
    Employee add(String firstname, String lastname);
    boolean remove(String firstname, String lastname);
    Employee get(int i);
    List<Employee> getAll();
}
