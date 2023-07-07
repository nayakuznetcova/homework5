package com.example.homework5.controller;

import com.example.homework5.employee.Employee;
import com.example.homework5.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String start(){
        return departmentService.displayStart();
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam("department") int department){
        return departmentService.maxSalaryByDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryByDepartment(@RequestParam("department") int department){
        return departmentService.minSalaryByDepartment(department);
    }

    @GetMapping(value = "/all", params = "department")
    public Collection<Employee> printByDepartment (@RequestParam("department") int department){
        return departmentService.printByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAllByDepartment (){
        return departmentService.printAllByDepartment();
    }

}
