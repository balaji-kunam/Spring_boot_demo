package com.demo.Jenkins;


import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public List<String> getEmployees() {
        return Arrays.asList("Ravi", "Priya", "John");
    }

    @PostMapping("/employees")
    public String addEmployee() {
        return "Employee Added";
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}
