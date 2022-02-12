package com.example.springapp.controller;

import com.example.springapp.domain.Department;
import com.example.springapp.dto.DepartmentDto;
import com.example.springapp.mapper.DepartmentMapper;
import com.example.springapp.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Department Controller", description = "The Department API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        Department department = DepartmentMapper.INSTANCE.departmentDtoToDepartment(departmentDto);
        service.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentDto);
    }

    @PostMapping("/addDepartments")
    public ResponseEntity<List<DepartmentDto>> saveDepartments(@RequestBody List<Department> departments) {
        List<DepartmentDto> departmentDto = DepartmentMapper.INSTANCE.departmentToDtos(service.saveDepartments(departments));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getDepartments()  {
        List<DepartmentDto> departmentDto = DepartmentMapper.INSTANCE.departmentToDtos(service.getDepartments());
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping("/departmentsByCountry/{country}")
    public ResponseEntity<List<DepartmentDto>> getDepartmentsByCountry(@PathVariable String country) {
        List<DepartmentDto> departmentDto = DepartmentMapper.INSTANCE.departmentToDtos(service.getDepartmentsByCountry(country));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping("/departmentsByCity/{city}")
    public ResponseEntity<List<DepartmentDto>> getDepartmentsByCity(@PathVariable String city) {
        List<DepartmentDto> departmentDto = DepartmentMapper.INSTANCE.departmentToDtos(service.getDepartmentsByCity(city));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping("/departmentById/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Integer id) {
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.departmentToDto(service.getDepartmentById(id));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping("/departmentByAddress/{address}")
    public ResponseEntity<DepartmentDto> getDepartmentByAddress(@PathVariable String address) {
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.departmentToDto(service.getDepartmentByAddress(address));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }


    @PutMapping("/updateDepartment")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody Department department) {
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.departmentToDto(service.updateDepartment(department));
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        service.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("City with id : " + id + " deleted");
    }

}
