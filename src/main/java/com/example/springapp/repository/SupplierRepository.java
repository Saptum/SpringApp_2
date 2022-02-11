package com.example.springapp.repository;

import com.example.springapp.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository  extends JpaRepository<Supplier, Integer> {
    Supplier findByName(String name);

    Supplier findByEmail(String email);

    Supplier findByPhone(String phone);
}
