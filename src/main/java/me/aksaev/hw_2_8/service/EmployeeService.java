package me.aksaev.hw_2_8.service;

import me.aksaev.hw_2_8.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String name, String surname, int department, int salary);

    Employee remove(String name, String surname, int department, int salary);

    Employee find(String name, String surname, int department, int salary);

    List<Employee> getAll();
}
