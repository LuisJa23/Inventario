package com.inventory.stock.service.purchase;

import com.inventory.stock.dto.purchase.PurchaseRegisterDTO;
import com.inventory.stock.dto.purchase.PurchaseResponseDTO;
import com.inventory.stock.model.product.Product;
import com.inventory.stock.model.product.add_ons.Batch;
import com.inventory.stock.model.purchase.Purchase;
import com.inventory.stock.model.purchase.add_ons.PurchaseDetails;
import com.inventory.stock.repository.product.ProductRepository;
import com.inventory.stock.repository.purchase.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;


    public PurchaseResponseDTO registerPurchase(PurchaseRegisterDTO purchaseRegisterDTO) {
        var purchase = new Purchase(purchaseRegisterDTO);

        List<PurchaseDetails> purchaseDetails = purchaseRegisterDTO.purchaseDetails().stream().map(purchaseDetailsRegisterDTO -> {
            Product product = productRepository.findById(purchaseDetailsRegisterDTO.batch().productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            Batch batch = new Batch(purchaseDetailsRegisterDTO.batch(), product);
            return new PurchaseDetails(purchaseDetailsRegisterDTO);
        }).collect(Collectors.toList());

        purchase.setPurchaseDetails(purchaseDetails);
        purchaseRepository.save(purchase);
        return new PurchaseResponseDTO(purchase);
    }
}
