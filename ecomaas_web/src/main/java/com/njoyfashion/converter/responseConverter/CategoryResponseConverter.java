package com.njoyfashion.converter.responseConverter;

import com.njoyfashion.dto.CategoryDto;
import com.njoyfashion.dto.responseDto.CategoryResponseDto;
import com.njoyfashion.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseConverter {
    public Category convert(CategoryResponseDto categoryResponseDto){
        Category category = new Category();
        category.setId(categoryResponseDto.getId());
        category.setName(categoryResponseDto.getName());
        return category;
    }

    public CategoryDto convert(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
