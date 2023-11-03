package com.njoyfashion.service;

import com.njoyfashion.converter.CategoryConverter;
import com.njoyfashion.converter.SubCategoryConverter;
import com.njoyfashion.converter.responseConverter.CategoryResponseConverter;
import com.njoyfashion.dto.CategoryDto;
import com.njoyfashion.dto.SubCategoryDto;
import com.njoyfashion.dto.SubCategoryDtoResponse;
import com.njoyfashion.dto.responseDto.CategoryResponseDto;
import com.njoyfashion.entity.Category;
import com.njoyfashion.entity.SubCategory;
import com.njoyfashion.repository.CategoryRepository;
import com.njoyfashion.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    CategoryConverter categoryConverter;
    @Autowired
    CategoryResponseConverter categoryResponseConverter;
    @Autowired
    SubCategoryConverter subCategoryConverter;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public List<CategoryDto> getAllCategory() {
        List<Category>  categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category : categories) {
            if (category != null){
                CategoryDto categoryDto = categoryResponseConverter.convert(category);
                List<SubCategory> subCategories = subCategoryRepository.findAllByCategoryId(category);
                List<SubCategoryDto> subCategoryDtoList = new ArrayList<>();
                for (SubCategory subCategory : subCategories){
                    SubCategoryDto subCategoryDto = subCategoryConverter.convert(subCategory);
                    subCategoryDtoList.add(subCategoryDto);
                }
                categoryDto.setSubCategoryDtoList(subCategoryDtoList);
                categoryDtoList.add(categoryDto);
            }
        }
        return categoryDtoList;
    }
}
