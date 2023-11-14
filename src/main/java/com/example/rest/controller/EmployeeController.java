package com.example.rest.controller;

import com.example.rest.model.Employee;
import com.example.rest.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @GetMapping
    public List<Employee> getEmployees(@RequestParam(value="sort", required = false, defaultValue = "id") String sortBy) {
        // sort by sortBy
        return DataRepository.employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : DataRepository.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        DataRepository.employees.add(employee);
        return employee;
    }

    @PutMapping
    public Employee putEmployee(@RequestBody Employee newEmployee) {
        for (Employee employee : DataRepository.employees) {
            if (employee.getId() == newEmployee.getId()) {
                employee.setName(newEmployee.getName());
                employee.setPhone(newEmployee.getPhone());
                employee.setCompany(newEmployee.getCompany());
            }
        }
        return newEmployee;
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id) {
        Iterator<Employee> iterator = DataRepository.employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
            }
        }
    }
}
