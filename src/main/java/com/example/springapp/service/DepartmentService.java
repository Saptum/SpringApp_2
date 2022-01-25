package com.example.springapp.service;

import com.example.springapp.model.Department;
import com.example.springapp.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public List<Department> saveDepartments(List<Department> departments) {
        return repository.saveAll(departments);
    }

    public List<Department> getDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Department getDepartmentByAddress(String address) {
        return repository.findByAddress(address);
    }

    public List<Department> getDepartmentsByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<Department> getDepartmentsByCity(String city) {
        return repository.findAllByCity(city);
    }

    public Department updateDepartment(Department department) {
        Department updatedDepartment = repository.findById(department.getId()).orElse(null);
        updatedDepartment.setDescription(department.getDescription());
        updatedDepartment.setCountry(department.getCountry());
        updatedDepartment.setCity(department.getCity());
        updatedDepartment.setAddress(department.getAddress());
        return repository.save(updatedDepartment);
    }

    public String deleteDepartment(int id) {
        repository.deleteById(id);
        return "Department " + id + " was deleted!";
    }
}
