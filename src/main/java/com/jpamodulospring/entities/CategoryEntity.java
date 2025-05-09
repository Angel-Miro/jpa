package com.jpamodulospring.entities;

import com.jpamodulospring.entities.enums.CodeCategoryEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * La anotación @Enumerated se usa para mapear Enum en JPA
     * puede ser EnumType.STRING o EnumType.ORDINAL
     *
     * */
    @Enumerated(EnumType.STRING)
    private CodeCategoryEnum code;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    @ToString.Exclude
    private List<ProductsCatalogEntity> productsCatalogs;

}
