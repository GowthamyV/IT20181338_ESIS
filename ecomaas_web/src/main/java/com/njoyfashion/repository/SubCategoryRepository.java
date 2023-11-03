package com.njoyfashion.repository;

import com.njoyfashion.entity.Category;
import com.njoyfashion.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubCategoryRepository extends CrudRepository<SubCategory,Long>, JpaRepository<SubCategory,Long> {
    List<SubCategory> findAllByCategoryId(Category id);
}
