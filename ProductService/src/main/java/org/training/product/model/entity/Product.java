package org.training.product.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "owner_id")
    private Long ownerId;

}
