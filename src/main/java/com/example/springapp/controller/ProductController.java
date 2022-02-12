package com.example.springapp.controller;

import com.example.springapp.domain.Department;
import com.example.springapp.domain.Product;
import com.example.springapp.dto.DepartmentDto;
import com.example.springapp.dto.ProductDto;
import com.example.springapp.mapper.DepartmentMapper;
import com.example.springapp.mapper.ProductMapper;
import com.example.springapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Controller", description = "The Product API")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Сохраняет продукт ")
    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        service.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @Operation(summary = "Сохраняет продукт")
    @PostMapping("/addProducts")
    public ResponseEntity<List<ProductDto>> addProducts(@RequestBody List<Product> products) {
        List<ProductDto> productDtos = ProductMapper.INSTANCE.productToDtos(service.saveProducts(products));
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @Operation(summary = "Возвращает продукт")
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAlProducts() {
        List<ProductDto> productDtos = ProductMapper.INSTANCE.productToDtos(service.getProducts());
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @Operation(summary = "Возвращает продукт по id")
    @GetMapping("/productById/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id) {
        ProductDto productDto = ProductMapper.INSTANCE.productToDto(service.getProductById(id));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @Operation(summary = "Возвращает продукт по названию")
    @GetMapping("/product/{name}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable String name) {
        ProductDto productDto = ProductMapper.INSTANCE.productToDto(service.getProductByName(name));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @Operation(summary = "Обновляет продукт")
    @PutMapping("/updateProduct")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody Product product) {
        ProductDto productDto = ProductMapper.INSTANCE.productToDto(service.updateProduct(product));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @Operation(summary = "Удаляет продукт по id")
    @DeleteMapping("/smartphones/{id}")
    public ResponseEntity<String>  deleteProduct(@PathVariable Integer id) {
       service.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product with id : " + " deleted!");

    }

}
