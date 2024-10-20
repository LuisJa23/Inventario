package com.inventory.stock.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        String barCode,
        @NotNull
        Double salePrice
) {
}
