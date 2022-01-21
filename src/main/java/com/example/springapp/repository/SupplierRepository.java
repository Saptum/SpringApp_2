package com.example.springapp.repository;

import com.example.springapp.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository  extends JpaRepository<Supplier, Integer> {
    Supplier findByName(String name);

    Supplier findByEmail(String email);

    Supplier findByPhone(String phone);
}
