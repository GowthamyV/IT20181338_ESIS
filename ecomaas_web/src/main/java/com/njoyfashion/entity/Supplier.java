package com.njoyfashion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long contactNumber;
}
