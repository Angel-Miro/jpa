package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductsCatalogEntity, UUID> {

    Optional<ProductsCatalogEntity> findByName(String name);

    List<ProductsCatalogEntity> findByNameLike(String name);

    @Query("from ProductsCatalogEntity p where p.price between :min and :max")
    List<ProductsCatalogEntity> findByBetweenTwoPrices(BigDecimal min, BigDecimal max);
}
