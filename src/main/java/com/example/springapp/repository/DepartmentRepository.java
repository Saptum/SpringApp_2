package com.example.springapp.repository;

import com.example.springapp.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
    Department findByAddress(String address);

    List<Department> findAllByCountry(String country);

    List<Department> findAllByCity(String city);
}
