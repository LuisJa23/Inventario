package com.inventory.stock.model.sale;


import com.inventory.stock.dto.sale.SaleRegisterDTO;
import com.inventory.stock.model.invoice.Invoice;
import com.inventory.stock.model.person.Person;
import com.inventory.stock.model.person.add_ons.UserLogin;
import com.inventory.stock.model.product.add_ons.Batch;
import com.inventory.stock.model.purchase.Purchase;
import com.inventory.stock.model.sale.add_ons.PaymentMethod;
import com.inventory.stock.model.sale.add_ons.SaleDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "sale")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime saleDate;
    private Double totalPrice;
    private PaymentMethod paymentMethod;
    private Double discountAmount;
    private Double taxAmount;




    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private UserLogin worker;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SaleDetails> saleDetails;

    @OneToOne(mappedBy = "sale")
    private Invoice invoice;

    public Sale(SaleRegisterDTO saleRegisterDTO) {
        this.saleDetails = new ArrayList<>();
        this.totalPrice = 0.0;
        saleRegisterDTO.saleDetails().forEach(detail -> {
            SaleDetails saleDetail = new SaleDetails(detail, this);
            this.saleDetails.add(saleDetail);
            this.totalPrice += saleDetail.getSubTotal();
        });
        this.saleDate = LocalDateTime.now();
    }
}
