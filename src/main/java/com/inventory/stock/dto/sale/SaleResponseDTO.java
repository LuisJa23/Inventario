package com.inventory.stock.dto.sale;

import com.inventory.stock.dto.sale.add_ons.SaleDetailsRegisterDTO;
import com.inventory.stock.dto.sale.add_ons.SaleDetailsResponseDTO;
import com.inventory.stock.model.sale.Sale;

import java.util.List;

public record SaleResponseDTO(
        List<SaleDetailsResponseDTO> saleDetails


) {
    public SaleResponseDTO(Sale sale) {
        this(sale.getSaleDetails().stream().map(SaleDetailsResponseDTO::new).toList());
    }


}
