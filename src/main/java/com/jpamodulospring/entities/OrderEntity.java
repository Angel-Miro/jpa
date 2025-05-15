package com.jpamodulospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "created_at")
    /**
     * En las versiones nuevas de jpa ya no es necesario usar la
     * anotacion @Column(name="nombre_columna")
     * ya que si en la bd esta con :"created_at"
     * spring lo parsea en automatico con la notacion de camello
     * createdAt
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 32, nullable = false)
    private String clientName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_bill", nullable = false, unique = true)
    private BillEntity bill;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductsEntity> products = new ArrayList<>();

    public void addProduct(ProductsEntity product) {
        this.products.add(product);
    }
}
