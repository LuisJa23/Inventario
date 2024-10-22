package com.inventory.stock.dto.sale.add_ons;

import com.inventory.stock.model.sale.add_ons.SaleDetails;

public record SaleDetailsResponseDTO(
        Integer quantity,
        Double unitPrice,
        Double subTotal) {

    public SaleDetailsResponseDTO(SaleDetails saleDetails) {
        this(saleDetails.getQuantity(), saleDetails.getUnitPrice(), saleDetails.getSubTotal());
    }
}
