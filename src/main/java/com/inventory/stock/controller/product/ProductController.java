package com.inventory.stock.controller.product;


import com.inventory.stock.dto.product.ProductRegisterDTO;
import com.inventory.stock.dto.product.ProductResponseDTO;
import com.inventory.stock.service.product.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProductResponseDTO> registerProduct(@RequestBody @Valid ProductRegisterDTO productRegisterDTO, UriComponentsBuilder uriBuilder){
        var product = productService.registerProduct(productRegisterDTO);
        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.id()).toUri();
        return ResponseEntity.created(uri).body(product);
    }


    @GetMapping
    @Transactional
    public ResponseEntity<PagedModel<ProductResponseDTO>> getAllProducts(@PageableDefault(size = 50) Pageable pageable){
        var page = productService.getAllProducts(pageable);
        PagedModel<ProductResponseDTO> pagedModel = new PagedModel<>(page);
        return ResponseEntity.ok(pagedModel);
    }
}
