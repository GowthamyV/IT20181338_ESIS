package com.njoyfashion.controller;

import com.njoyfashion.dto.CategoryDto;
import com.njoyfashion.dto.SubCategoryDto;
import com.njoyfashion.dto.responseDto.CategoryResponseDto;
import com.njoyfashion.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }
}
