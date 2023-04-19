package me.aksaev.hw_2_8.controller;

import me.aksaev.hw_2_8.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import me.aksaev.hw_2_8.model.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firsName") String name,
                        @RequestParam("firsName") String surname,
                        @RequestParam("departmentId") int department,
                        @RequestParam("salary") int salary) {
        return employeeService.add(name, surname, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firsName") String name,
                           @RequestParam("firsName") String surname,
                           @RequestParam("departmentId") int department,
                           @RequestParam("salary") int salary) {
        return employeeService.remove(name, surname, department, salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firsName") String name,
                         @RequestParam("firsName") String surname,
                         @RequestParam("departmentId") int department,
                         @RequestParam("salary") int salary) {
        return employeeService.find(name, surname, department, salary);
    }

    @GetMapping
    public Collection<Employee> getEmployee() {
        return employeeService.getAll();
    }

}
