package com.inventory.stock.model.purchase.add_ons;


import com.inventory.stock.dto.purchase.add_ons.PurchaseDetailsRegisterDTO;
import com.inventory.stock.model.product.Product;
import com.inventory.stock.model.product.add_ons.Batch;
import com.inventory.stock.model.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "purchase_details")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public PurchaseDetails(PurchaseDetailsRegisterDTO purchaseDetailsRegisterDTO) {
        this.quantity = purchaseDetailsRegisterDTO.batch().quantity();
        this.unitPrice = purchaseDetailsRegisterDTO.batch().unitPrice();


    }

}
