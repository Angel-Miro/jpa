package com.jpamodulospring.dtos;


import com.jpamodulospring.entities.enums.CodeCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCatalogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private List<CategoryDTO> categories;


    /**
     * Se usa como clase interna ya que solo se usa en esta clase,
     * en caso contrario crear una clase aparte
     * */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CategoryDTO {
        private CodeCategoryEnum code;
        private String description;
    }
}
