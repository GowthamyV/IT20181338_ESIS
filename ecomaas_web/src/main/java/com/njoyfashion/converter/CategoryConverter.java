package com.njoyfashion.converter;

import com.njoyfashion.dto.CategoryDto;
import com.njoyfashion.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category convert(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
      //  category.setDescription(categoryDto.getDescription());
        return category;
    }

    public CategoryDto convert(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
     //   categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }
}
