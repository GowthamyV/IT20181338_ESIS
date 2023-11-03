package com.njoyfashion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    char[] size;
    String Description;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    Category categoryId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    Supplier supplierId;
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    @ManyToOne
    SubCategory subCategoryId;
    String imageUrl;
    Double price;
}
