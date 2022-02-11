package com.example.springapp.mapper;

import com.example.springapp.domain.Department;
import com.example.springapp.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto departmentToDto(Department department);

    List<DepartmentDto> departmentToDtos (List<Department> departmentList);

    Department departmentDtoToDepartment (DepartmentDto departmentDto);
}
