package com.njoyfashion.dto;

import lombok.Data;

@Data
public class SubCategoryDtoResponse {

    CategoryDto categoryId;
    SubCategoryDto subCategoryDto;
    Long id;
    String name;
    String description;
}
