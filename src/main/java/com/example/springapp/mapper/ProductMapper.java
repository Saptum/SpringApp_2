package com.example.springapp.mapper;

import com.example.springapp.domain.Product;
import com.example.springapp.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product product);

    List<ProductDto> productToDtos(List<Product> productList);

    Product productDtoToProduct(ProductDto productDto);
}
