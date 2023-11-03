package com.njoyfashion.dto.responseDto;

import com.njoyfashion.dto.SubCategoryDto;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {
    Long id;
    String name;
    List<SubCategoryDto> subCategoryDto;
}
