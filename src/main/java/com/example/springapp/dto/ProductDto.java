package com.example.springapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность продукта")
public class ProductDto {
    @Schema(description = "Название продукта", example = "Продукт")
    private String name;
    @Schema(description = "Количество продукта", example = "100")
    private int quantity;
    @Schema(description = "Цена продукта", example = "100$")
    private double price;
}
