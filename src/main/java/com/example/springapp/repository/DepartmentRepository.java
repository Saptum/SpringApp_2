package com.example.springapp.repository;

import com.example.springapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
    Department findByAddress(String address);

    List<Department> findAllByCountry(String country);

    List<Department> findAllByCity(String city);
}
