package com.example.springapp.controller;

import com.example.springapp.model.Department;
import com.example.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/addDepartment")
    public Department saveDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);
    }

    @PostMapping("/addDepartments")
    public List<Department> saveDepartments(@RequestBody List<Department> departments) {
        return service.saveDepartments(departments);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return service.getDepartments();
    }

    @GetMapping("/departmentsByCountry/{country}")
    public List<Department> getDepartmentsByCountry(@PathVariable String country) {
        return service.getDepartmentsByCountry(country);
    }

    @GetMapping("/departmentsByCity/{city}")
    public List<Department> getDepartmentsByCity(@PathVariable String city) {
        return service.getDepartmentsByCity(city);
    }

    @GetMapping("/departmentById/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return service.getDepartmentById(id);
    }

    @GetMapping("/departmentByAddress/{address}")
    public Department getDepartmentByAddress(@PathVariable String address) {
        return service.getDepartmentByAddress(address);
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return service.deleteDepartment(id);
    }

}
