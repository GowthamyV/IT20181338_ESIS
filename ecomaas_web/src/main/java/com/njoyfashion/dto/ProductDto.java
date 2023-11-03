package com.njoyfashion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.njoyfashion.entity.Supplier;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    Long id;
    String name;
    char[] size;
    String imageUrl;
    Double price;
    String description;
    SubCategoryDto subCategoryDto;
  //  SupplierDto supplierDto;
}
