package com.example.employee_api.controller;

import com.example.employee_api.model.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag(name = "Employee Controller", description = "Manages employee data with form and display operations")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    @Operation(summary = "Show employee form", description = "Displays the form to add a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Form displayed successfully")
    })
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/saveEmployee")
    @Operation(summary = "Save a new employee", description = "Saves employee data submitted via the form")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid employee data")
    })
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {
        System.out.println("Received employee: " + employee);
        employeeRepository.save(employee);
        model.addAttribute("message", "Employee saved successfully!");
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @GetMapping("/displayAll")
    @Operation(summary = "Display all employees", description = "Retrieves and displays all employees from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees retrieved successfully")
    })
    public String displayAll(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "displayAll";
    }

    @GetMapping("/display/{id}")
    @Operation(summary = "Display employee by ID", description = "Retrieves and displays an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public String displayById(
            @Parameter(description = "ID of the employee to retrieve") @PathVariable String id,
            Model model
    ) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "display";
    }
}