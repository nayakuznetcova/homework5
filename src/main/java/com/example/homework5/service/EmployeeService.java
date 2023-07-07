package com.example.homework5.service;

import com.example.homework5.employee.Employee;
import com.example.homework5.exception.EmployeeAlreadyAddedException;
import com.example.homework5.exception.EmployeeNotFoundException;
import com.example.homework5.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    Map<String, Employee> people = new HashMap<>();

    @Override
    public String startDisplay() {
        return "<h1>Добро пожаловать</h1>";
    }

    @Override
    public Employee add(String firstname, String lastname, int salary, int departament) {
        Employee object = new Employee(firstname, lastname, salary, departament);
        if (people.size() >= 10) {
            throw new EmployeeStorageIsFullException("Лимит сотрудников в списке превышен");
        } else if (people.containsKey(object.search())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке");
        } else {
            people.put(object.search(), object);
            return object;
        }

    }

    @Override
    public Employee remove(String firstname, String lastname) {
        if (!people.containsKey(firstname + lastname)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        return people.remove(firstname + lastname);
    }

    @Override
    public Employee get(String firstname, String lastname) {
        if (people.containsKey(firstname + lastname)) {
            return people.get(firstname + lastname);
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(people.values());
    }

}
