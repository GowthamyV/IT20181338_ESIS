package com.njoyfashion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Base64;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSaveDto {
    Long id;
    String name;
    char[] size;
    List<ImageDto> imageBase64;
    Double price;
    String description;
    SubCategoryDto subCategoryDto;
  //  SupplierDto supplierDto;
}
