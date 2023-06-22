package com.example.homework5.controller;

import com.example.homework5.exception.EmployeeAlreadyAddedException;
import com.example.homework5.exception.EmployeeNotFoundException;
import com.example.homework5.exception.EmployeeStorageIsFullException;
import com.example.homework5.service.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterface employeeServiceInterface;

    public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }

    @GetMapping()
    public String start(){
        return employeeServiceInterface.startDisplay();
    }

    @GetMapping(path="/add")
    public String add(@RequestParam ("lastname") String lastname, @RequestParam ("surname") String surname){
        try {
            return employeeServiceInterface.add(lastname, surname).toString();
        }catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e){
            return e.getMessage();
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam ("lastname") String lastname, @RequestParam ("surname") String surname){
        try {
            return "result " + employeeServiceInterface.remove(lastname, surname);
        }catch (EmployeeNotFoundException e){
            return e.getMessage();
        }
    }

    @GetMapping("/get")
    public String get (@RequestParam("number") int number){
        try {
            return employeeServiceInterface.get(number).toString();
        }catch (EmployeeNotFoundException e){
            return e.getMessage();
        }
    }

    @GetMapping("/getall")
    public String getAll(){
        return employeeServiceInterface.getAll().toString();
    }


    //todo создать новую папку с исключениями
}
