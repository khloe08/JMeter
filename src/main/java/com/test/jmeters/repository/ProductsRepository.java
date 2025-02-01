package com.test.jmeters.repository;

import com.test.jmeters.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface ProductsRepository extends JpaRepository<Products, Long> {

    Page<Products> findByCategoryAndPriceBetweenAndRatingGreaterThanEqual(
            String category, double minPrice, double maxPrice, double rating, Pageable pageable);
    Page<Products> findByCategoryAndPriceBetweenAndRatingGreaterThanEqualAndCreatedAtBefore(
            String category, double minPrice, double maxPrice, double minRating, LocalDateTime beforeDate, Pageable pageable);

}
