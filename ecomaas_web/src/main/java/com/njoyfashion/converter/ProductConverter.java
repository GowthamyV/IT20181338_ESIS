package com.njoyfashion.converter;

import com.njoyfashion.dto.ProductDto;
import com.njoyfashion.entity.Products;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    @Autowired
    SupplierConverter supplierConverter;
    @Autowired
    SubCategoryConverter subCategoryConverter;

    public ProductDto convert(Products products){
        ProductDto productDto = new ProductDto();
        productDto.setId(products.getId());
        productDto.setName(products.getName());
        productDto.setSize(products.getSize());
        productDto.setImageUrl(products.getImageUrl());
        productDto.setDescription(products.getDescription());
        productDto.setSubCategoryDto(subCategoryConverter.convert(products.getSubCategoryId()));
    //    productDto.setSupplierDto(supplierConverter.convert(products.getSupplierId()));
        productDto.setPrice(products.getPrice());
        return productDto;
    }

    public Products convert(ProductDto productDto){
        Products products = new Products();
        products.setId(productDto.getId());
        products.setName(productDto.getName());
        products.setSize(productDto.getSize());
        products.setImageUrl(productDto.getImageUrl());
        products.setDescription(productDto.getDescription());
        products.setSubCategoryId(subCategoryConverter.convert(productDto.getSubCategoryDto()));
    //    products.setSupplierId(supplierConverter.convert(productDto.getSupplierDto()));
        products.setPrice(productDto.getPrice());
        return products;
    }
}
