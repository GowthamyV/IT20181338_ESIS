package com.njoyfashion.repository;

import com.njoyfashion.entity.Category;
import com.njoyfashion.entity.Products;
import com.njoyfashion.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products,Long>, JpaRepository<Products,Long> {

   List<Products> findProductsBySubCategoryId(SubCategory subCategoryId);

   List<Products> findProductsByCategoryId(Category categoryId);
}
