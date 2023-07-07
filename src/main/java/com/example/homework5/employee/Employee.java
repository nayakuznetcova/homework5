package com.example.homework5.employee;

import java.util.Objects;

public class Employee {
    private String firstname;
    private String lastname;
    private int salary;
    private int department;

    public Employee(String firstname, String lastname, int salary, int department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
    }

    public String search() {
        return firstname + lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
