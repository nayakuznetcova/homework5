package com.example.homework5.service;

import com.example.homework5.employee.Employee;
import com.example.homework5.exception.EmployeeAlreadyAddedException;
import com.example.homework5.exception.EmployeeNotFoundException;
import com.example.homework5.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService implements EmployeeServiceInterface{
    List<Employee> people = new ArrayList<>();
    @Override
    public String startDisplay(){
        return "<h1>Добро пожаловать</h1>";
    }

    @Override
    public Employee add(String firstname, String lastname){
        Employee object = new Employee(firstname, lastname);
        if(people.size()>=10) {
            throw new EmployeeStorageIsFullException("Лимит сотрудников в списке превышен");
        }else if (people.contains(object)){
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке");
        }else{
            people.add(object);
            return object;
        }

    }

    @Override
    public boolean remove(String firstname, String lastname) {
        Employee oblect = new Employee(firstname, lastname);
        if(!people.contains(oblect)){
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
         return people.remove(oblect);
    }

    @Override
    public Employee get(int number){
        if (people.size()<number){
            throw new EmployeeNotFoundException("Не найдено результатов по запросу");
        }
        return people.get(number);
    }

    @Override
    public List<Employee> getAll() {
        return people;
    }

}
