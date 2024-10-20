package com.inventory.stock.model.product;




import com.inventory.stock.dto.product.ProductRegisterDTO;
import com.inventory.stock.model.product.add_ons.Batch;
import com.inventory.stock.model.sale.add_ons.SaleDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "product")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String  barCode;
    private Double salePrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SaleDetails> saleDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Batch> batches;




    public Product(ProductRegisterDTO productRegisterData) {
        this.name = productRegisterData.name();
        this.barCode = productRegisterData.barCode();
        this.salePrice = productRegisterData.salePrice();

    }
}
