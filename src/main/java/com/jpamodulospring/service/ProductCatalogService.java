package com.jpamodulospring.service;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.entities.enums.LikeKey;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductCatalogService {

    ProductsCatalogEntity findById(UUID id);
    ProductsCatalogEntity findByName(String name);
    List<ProductsCatalogEntity> findNameLike(LikeKey key, String word);
    List<ProductsCatalogEntity> findBetweenPrice(BigDecimal min, BigDecimal max);
    List<ProductsCatalogEntity> findByCategoryName(BigInteger id);
    //List<ProductsCatalogEntity> findByLaunchingDate(LocalDate date, DateEval key);
    List<ProductsCatalogEntity> findByBrandAndRating(String brand, Short rating);
    //List<StatisticsProduct> findStatistics();
    Page<ProductsCatalogEntity> findAll(String field, Boolean desc);
    Page<ProductsCatalogEntity> findAllByBrand(String brand);
    Integer countByBrand(String brand);

}
