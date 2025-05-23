package com.jpamodulospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products_catalog", indexes = {
        @Index(name = "idx_product_name", columnList = "product_name")
})
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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(
            name = "product_join_category",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<CategoryEntity> categories = new LinkedList<>();


    public void addCategory(CategoryEntity category) {
        this.categories.add(category);
    }
}
