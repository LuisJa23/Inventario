package com.inventory.stock.dto.sale.add_ons;

public record SaleDetailsRegisterDTO(
        Long productId,
        Integer quantity,
        Double unitPrice,
        Double subTotal
) {
}
