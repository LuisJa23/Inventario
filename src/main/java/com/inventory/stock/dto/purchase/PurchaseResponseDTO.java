package com.inventory.stock.dto.purchase;

import com.inventory.stock.dto.purchase.add_ons.PurchaseDetailsResponseDTO;
import com.inventory.stock.model.purchase.Purchase;


import java.time.LocalDateTime;
import java.util.List;

public record PurchaseResponseDTO(
        Long id,
        LocalDateTime purchaseDate,
        Double total
        //List<PurchaseDetailsResponseDTO> purchaseDetails


) {
    public PurchaseResponseDTO (Purchase purchase) {
        this(purchase.getId(), purchase.getPurchaseDate(), purchase.getTotal());
    }

}
