package me.aksaev.hw_2_8.service;

import me.aksaev.hw_2_8.exception.EmployeeAlreadyAddedException;
import me.aksaev.hw_2_8.exception.EmployeeNotFoundException;
import me.aksaev.hw_2_8.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import me.aksaev.hw_2_8.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String name, String surname, int department, int salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee remove(String name, String surname, int department, int salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String name, String surname, int department, int salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }


}
