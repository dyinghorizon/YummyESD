package com.nishad.yummyesd.service;

import com.nishad.yummyesd.dto.ProductRequest;
import com.nishad.yummyesd.dto.ProductResponse;
import com.nishad.yummyesd.entity.Product;
import com.nishad.yummyesd.mapper.ProductMapper;
import com.nishad.yummyesd.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repository;
    private final ProductMapper mapper;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = mapper.toEntity(request);
        Product savedProduct = repository.save(product);
        return mapper.toResponse(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProduct(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Optional<Product> existingProduct = repository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(request.name());
            product.setPrice(request.price());
            return mapper.toResponse(repository.save(product));
        }
        throw new RuntimeException("Product not found");
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public List<ProductResponse> getTop2ProductsByPriceRange() {
        return repository.findTop2ProductsByPriceRange()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}