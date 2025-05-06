package com.jpamodulospring.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Al llamarse el campo igual que en la BD no es necesario poner el @Column
    private BigInteger quantity;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private OrderEntity order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product_catalog")
    private ProductsCatalogEntity catalog;
}
