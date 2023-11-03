package com.njoyfashion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    Long id;
    String name;
   // String description;
    List<SubCategoryDto> subCategoryDtoList;
}
