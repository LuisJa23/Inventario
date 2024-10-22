package com.inventory.stock.dto.sale;

import com.inventory.stock.dto.sale.add_ons.SaleDetailsRegisterDTO;

import java.util.List;

public record SaleRegisterDTO(
        List<SaleDetailsRegisterDTO> saleDetails
) {
}
