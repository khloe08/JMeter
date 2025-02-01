package com.test.jmeters.controller;


import com.test.jmeters.entity.Products;
import com.test.jmeters.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/product")
    public Page<Products> getProductsList() {

        return productsService.getProductsList();
    }

    @GetMapping("/product_tune")
    public Page<Products> getProductsTuneList() {

        return productsService.getProductsTuneList();
    }

}