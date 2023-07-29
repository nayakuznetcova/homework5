package com.example.homework5.service;

import com.example.homework5.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String displayStart() {
        return "<h1>Добро пожаловать</h1>";
    }

    @Override
    public Employee maxSalaryByDepartment(int department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден"));
    }

    @Override
    public Employee minSalaryByDepartment(int department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден"));
    }

    @Override
    public Collection<Employee> printByDepartment(int department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> printAllByDepartment() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

}
