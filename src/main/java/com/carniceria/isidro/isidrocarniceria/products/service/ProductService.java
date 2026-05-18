package com.carniceria.isidro.isidrocarniceria.products.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.exception.ResourceNotFoundException;
import com.carniceria.isidro.isidrocarniceria.mapper.Mapper;
import com.carniceria.isidro.isidrocarniceria.products.dto.ProductResponseDTO;
import com.carniceria.isidro.isidrocarniceria.products.entity.Product;
import com.carniceria.isidro.isidrocarniceria.products.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductResponseDTO> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Product not found  "));

        return Optional.of(Mapper.productToResponseDTO(product));
    }
}
