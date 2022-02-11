package com.example.springapp.mapper;

import com.example.springapp.domain.Supplier;
import com.example.springapp.dto.SupplierDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDto supplierToDto(Supplier supplier);

    List<SupplierDto> supplierToDtos (List<Supplier> supplierList);

    Supplier supplierDtoToSupplier(SupplierDto supplierDto);
}
