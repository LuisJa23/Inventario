package com.inventory.stock.model.purchase;


import com.inventory.stock.dto.purchase.PurchaseRegisterDTO;
import com.inventory.stock.model.purchase.add_ons.PurchaseDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "purchase")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime purchaseDate;
    private Double total;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PurchaseDetails> purchaseDetails;

    public Purchase( PurchaseRegisterDTO purchaseRegisterDTO) {

        this.purchaseDate = LocalDateTime.now();


    }
}
