package com.njoyfashion.repository;

import com.njoyfashion.entity.Category;
import com.njoyfashion.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>, JpaRepository<Category,Long> {

}
