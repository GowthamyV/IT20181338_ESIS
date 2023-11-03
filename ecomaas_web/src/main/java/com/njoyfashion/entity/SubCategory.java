package com.njoyfashion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subcategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    Category categoryId;
}
