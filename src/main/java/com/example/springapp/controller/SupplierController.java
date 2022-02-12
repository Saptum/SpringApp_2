package com.example.springapp.controller;

import com.example.springapp.domain.Supplier;
import com.example.springapp.dto.SupplierDto;
import com.example.springapp.mapper.SupplierMapper;
import com.example.springapp.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Supplier Controller", description = "The Supplier API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {

    private  final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }


    @PostMapping("/addSupplier")
    public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.INSTANCE.supplierDtoToSupplier(supplierDto);
      service.saveSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierDto);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierDto>> getSuppliers() {
        List <SupplierDto> supplierDtos = SupplierMapper.INSTANCE.supplierToDtos(service.getSuppliers());
        return ResponseEntity.status(HttpStatus.OK).body(supplierDtos);
    }

    @GetMapping("/supplierById/{id}")
    public ResponseEntity <SupplierDto> getSupplierById(@PathVariable int id) {
      SupplierDto supplierDto = SupplierMapper.INSTANCE.supplierToDto(service.getSupplierById(id));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDto);
    }

    @GetMapping("/supplierByEmail/{email}")
    public ResponseEntity <SupplierDto> getSupplierByEmail(@PathVariable String email) {
        SupplierDto supplierDto = SupplierMapper.INSTANCE.supplierToDto(service.getSupplierByEmail(email));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDto);
    }

    @GetMapping("/supplierByName/{name}")
    public ResponseEntity <SupplierDto>  getSupplierByName(@PathVariable String name) {
        SupplierDto supplierDto = SupplierMapper.INSTANCE.supplierToDto(service.getSupplierByName(name));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDto);
    }

    @GetMapping("/supplierByPhone/{phone}")
    public ResponseEntity <SupplierDto>  getSupplierByPhone(@PathVariable String phone) {
        SupplierDto supplierDto = SupplierMapper.INSTANCE.supplierToDto(service.getSupplierByPhone(phone));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDto);
    }

    @PutMapping("/update")
    public ResponseEntity <SupplierDto>  updateSupplier(@RequestBody Supplier supplier) {
        SupplierDto supplierDto = SupplierMapper.INSTANCE.supplierToDto(service.updateSupplier(supplier));
        return ResponseEntity.status(HttpStatus.OK).body(supplierDto);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        service.deleteSupplier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier with id : " + id + " deleted");

    }

}
