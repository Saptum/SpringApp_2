package com.example.springapp.service;

import com.example.springapp.model.Supplier;
import com.example.springapp.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private  final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier saveSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    public List<Supplier> saveAllSuppliers(List<Supplier> suppliers) {
        return repository.saveAll(suppliers);
    }

    public List<Supplier> getSuppliers() {
        return repository.findAll();
    }

    public Supplier getSupplierById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Supplier getSupplierByName(String name) {
        return repository.findByName(name);
    }

    public Supplier getSupplierByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Supplier getSupplierByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Supplier updateSupplier(Supplier supplier) {
        Supplier updatedSupplier = repository.findById(supplier.getId()).orElse(null);
        updatedSupplier.setAddress(supplier.getAddress());
        updatedSupplier.setEmail(supplier.getEmail());
        updatedSupplier.setName(supplier.getName());
        updatedSupplier.setPhone(supplier.getPhone());
        return repository.save(updatedSupplier);
    }

    public String deleteSupplier(int id) {
        repository.deleteById(id);
        return "Supplier " + id + " was deleted!";
    }


}
