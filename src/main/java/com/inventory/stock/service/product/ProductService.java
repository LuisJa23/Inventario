package com.inventory.stock.service.product;


import com.inventory.stock.dto.product.ProductRegisterDTO;
import com.inventory.stock.dto.product.ProductResponseDTO;
import com.inventory.stock.model.product.Product;
import com.inventory.stock.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO registerProduct(ProductRegisterDTO productRegisterDTO) {
        var product = new Product(productRegisterDTO);
        productRepository.save(product);
        return new ProductResponseDTO(product);
    }

    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll( pageable).map(ProductResponseDTO::new);
    }


}
