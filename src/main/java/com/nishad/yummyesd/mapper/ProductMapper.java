package com.nishad.yummyesd.mapper;

import com.nishad.yummyesd.dto.ProductRequest;
import com.nishad.yummyesd.dto.ProductResponse;
import com.nishad.yummyesd.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
