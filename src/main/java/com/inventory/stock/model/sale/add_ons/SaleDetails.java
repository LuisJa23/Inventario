package com.inventory.stock.model.sale.add_ons;

import com.inventory.stock.dto.sale.add_ons.SaleDetailsRegisterDTO;
import com.inventory.stock.model.product.Product;
import com.inventory.stock.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sale_details")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer quantity;
    private Double unitPrice;
    private Double subTotal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public SaleDetails(SaleDetailsRegisterDTO saleDetailsRegisterDTO, Sale sale){
        this.quantity = saleDetailsRegisterDTO.quantity();
        this.unitPrice = saleDetailsRegisterDTO.unitPrice();
        this.subTotal = saleDetailsRegisterDTO.subTotal();
        this.sale = sale;
    }
}
