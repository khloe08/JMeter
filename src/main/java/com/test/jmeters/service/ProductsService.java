package com.test.jmeters.service;

import com.test.jmeters.entity.Products;
import com.test.jmeters.repository.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    public Page<Products> getProductsList() {
        Pageable pageable = PageRequest.of(100, 50, Sort.by("createdAt").descending());
        return productRepository.findByCategoryAndPriceBetweenAndRatingGreaterThanEqual(
                "Electronics", 50, 200, 4.0, pageable);
    }

    public Page<Products> getProductsTuneList() {
        Pageable pageable = PageRequest.of(0, 50, Sort.by("createdAt").descending());
        return productRepository.findByCategoryAndPriceBetweenAndRatingGreaterThanEqualAndCreatedAtBefore(
                "Electronics", 50, 200, 4.0, LocalDateTime.of(2025, 1, 1, 0, 0), pageable);
    }

}
