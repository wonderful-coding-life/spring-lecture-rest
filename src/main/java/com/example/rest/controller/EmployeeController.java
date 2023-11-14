package com.example.rest.controller;

import com.example.rest.model.Employee;
import com.example.rest.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee", method = RequestMethod.GET)
@Slf4j
public class EmployeeController {
    @GetMapping("/{id}")
    public Employee getEmployeeById(int id) {
        for (Employee employee : DataRepository.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
