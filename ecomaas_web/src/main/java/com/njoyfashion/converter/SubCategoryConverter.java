package com.njoyfashion.converter;

import com.njoyfashion.dto.SubCategoryDto;
import com.njoyfashion.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryConverter {
    @Autowired
    CategoryConverter categoryConverter;

    public SubCategoryDto convert(SubCategory subCategory){
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setId(subCategory.getId());
        subCategoryDto.setName(subCategory.getName());
//        subCategoryDto.setDescription(subCategory.getDescription());
    //    subCategoryDto.setCategoryDto(categoryConverter.convert(subCategory.getCategoryId()));
        return subCategoryDto;
    }

    public SubCategory convert(SubCategoryDto subCategoryDto){
        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryDto.getId());
        subCategory.setName(subCategoryDto.getName());
//        subCategory.setDescription(subCategoryDto.getDescription());
     //   subCategory.setCategoryId(categoryConverter.convert(subCategoryDto.getCategoryDto()));
        return subCategory;
    }
}
