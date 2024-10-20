package com.inventory.stock.dto.purchase;

import com.inventory.stock.dto.purchase.add_ons.PurchaseDetailsRegisterDTO;
import com.inventory.stock.model.purchase.add_ons.PurchaseDetails;

import java.util.List;

public record PurchaseRegisterDTO(
        List<PurchaseDetailsRegisterDTO> purchaseDetails
) {




}
