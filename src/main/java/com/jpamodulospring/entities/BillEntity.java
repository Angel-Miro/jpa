package com.jpamodulospring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "bill")
@Data
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

    //@ToString.Exclude
    //@OneToOne(mappedBy = "bill")
    //private OrderEntity order;
}
