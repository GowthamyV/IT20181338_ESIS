package com.njoyfashion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productimage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    Products products;
    private String imageUrl;
}
