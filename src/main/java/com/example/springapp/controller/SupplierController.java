package com.example.springapp.controller;

import com.example.springapp.domain.Supplier;
import com.example.springapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService service;


    @PostMapping("/addSupplier")
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return service.saveSupplier(supplier);
    }

    @PostMapping("/addSuppliers")
    public List<Supplier> addSuppliers(@RequestBody List<Supplier> suppliers) {
        return service.saveAllSuppliers(suppliers);
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return service.getSuppliers();
    }

    @GetMapping("/supplierById/{id}")
    public Supplier getSupplierById(@PathVariable int id) {
        return service.getSupplierById(id);
    }

    @GetMapping("/supplierByEmail/{email}")
    public Supplier getSupplierByEmail(@PathVariable String email) {
        return service.getSupplierByEmail(email);
    }

    @GetMapping("/supplierByName/{name}")
    public Supplier getSupplierByName(@PathVariable String name) {
        return service.getSupplierByName(name);
    }

    @GetMapping("/supplierByPhone/{phone}")
    public Supplier getSupplierByPhone(@PathVariable String phone) {
        return service.getSupplierByPhone(phone);
    }

    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {
        return service.updateSupplier(supplier);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable int id) {
        return service.deleteSupplier(id);
    }
}
