package com.inventory.stock.repository.purchase;

import com.inventory.stock.model.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
