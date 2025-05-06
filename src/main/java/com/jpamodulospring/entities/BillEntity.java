package com.jpamodulospring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillEntity {

    @Id
    @Column(nullable = false, length = 64)
    private String id;

    @Column
    private BigDecimal totalAmount;

    @Column(name = "client_rfc", length = 14, nullable = false)
    private String rfc;

    /**
     * Esto es para evitar dependencia circular
     */

    @ToString.Exclude
    @OneToOne(mappedBy = "bill", cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderEntity order;
}
