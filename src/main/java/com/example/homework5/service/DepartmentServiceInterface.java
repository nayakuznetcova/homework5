package com.example.homework5.service;

import com.example.homework5.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    String displayStart();

    Employee maxSalaryByDepartment(int department);

    Employee minSalaryByDepartment(int department);

    Collection<Employee> printByDepartment(int department);

    Map<Integer, List<Employee>> printAllByDepartment();
}
