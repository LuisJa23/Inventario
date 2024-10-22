package com.inventory.stock.dto.product;

import com.inventory.stock.model.product.Product;

public record ProductResponseDTO(
        Long id,
        String name,
        String barCode,
        Double salePrice,
        Integer stock



) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getBarCode(), product.getSalePrice(), product.getStock());
    }
}
