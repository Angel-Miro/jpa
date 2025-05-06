package com.jpamodulospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "products_catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsCatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_name", length = 64)
    private String name;

    @Column(name = "brand_name", length = 64)
    private String brand;

    private String description;

    private BigDecimal price;

    @Column(name = "launching_date")
    private LocalDate launchDate;

    private Boolean isDiscount;

    private Short rating;
}
