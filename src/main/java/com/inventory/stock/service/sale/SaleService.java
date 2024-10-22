package com.inventory.stock.service.sale;

import com.inventory.stock.dto.sale.SaleRegisterDTO;
import com.inventory.stock.dto.sale.SaleResponseDTO;
import com.inventory.stock.model.product.Product;
import com.inventory.stock.model.sale.Sale;
import com.inventory.stock.model.sale.add_ons.SaleDetails;
import com.inventory.stock.repository.product.ProductRepository;
import com.inventory.stock.repository.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class
SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    public SaleResponseDTO registerSale(SaleRegisterDTO saleRegisterDTO) {
        var sale = new Sale(saleRegisterDTO);

        List<SaleDetails> saleDetails = saleRegisterDTO.saleDetails().stream().map(saleDetailsRegisterDTO -> {
            Product product = productRepository.findById(saleDetailsRegisterDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            product.setStock(product.getStock() - saleDetailsRegisterDTO.quantity());
            productRepository.save(product);
            return new SaleDetails(saleDetailsRegisterDTO, sale);
        }).collect(Collectors.toList());




        sale.setSaleDetails(saleDetails);
        saleRepository.save(sale);
        return new SaleResponseDTO(sale);
    }

    public Page<SaleResponseDTO> getAllSale(Pageable pageable) {
        return saleRepository.findAll(pageable).map(SaleResponseDTO::new);
    }
}
