package com.njoyfashion.controller;

import com.njoyfashion.dto.ProductDto;
import com.njoyfashion.dto.ProductSaveDto;
import com.njoyfashion.entity.SubCategory;
import com.njoyfashion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/sub/{subCategoryId}")
    public List<ProductDto> getProductBySubCategoryId(@PathVariable Long subCategoryId) {
        return productService.getProductBySubCategoryId(subCategoryId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDto> getProductByCategoryId(@PathVariable Long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @PostMapping("/save")
    public String saveProductDetails(@RequestBody ProductSaveDto productDto) {
        if (productService.saveProductDetails(productDto) != null) {
            return "Success";
        }
        return "Failed";
    }
}
