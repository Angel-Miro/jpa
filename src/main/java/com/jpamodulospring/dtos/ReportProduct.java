package com.jpamodulospring.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportProduct {
    private String name;
    private Double average;
    private BigDecimal totalPrice;
}
