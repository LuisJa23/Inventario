package com.inventory.stock.controller.purchase;


import com.inventory.stock.dto.purchase.PurchaseRegisterDTO;
import com.inventory.stock.dto.purchase.PurchaseResponseDTO;
import com.inventory.stock.service.purchase.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> registerPurchase(@RequestBody @Valid PurchaseRegisterDTO purchaseRegisterDTO, UriComponentsBuilder uriBuilder){
        var purchase = purchaseService.registerPurchase(purchaseRegisterDTO);
        var uri = uriBuilder.path("/purchase/{id}").buildAndExpand(purchase.id()).toUri();
        return ResponseEntity.created(uri).body(purchase);
    }




}
