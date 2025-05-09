package com.jpamodulospring.service.impl;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.repositories.ProductCatalogRepository;
import com.jpamodulospring.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public ProductsCatalogEntity findById(UUID id) {
        return this.productCatalogRepository.findById(id).orElseThrow();
    }

    @Override
    public ProductsCatalogEntity findByName(String name) {
        return this.productCatalogRepository.findByName(name).orElse(ProductsCatalogEntity.builder().build());
    }

    @Override
    public List<ProductsCatalogEntity> findNameLike(String key) {
        return this.productCatalogRepository.findByNameLike(key);
    }

    @Override
    public List<ProductsCatalogEntity> findBetweenPrice(BigDecimal min, BigDecimal max) {
        return this.productCatalogRepository.findByBetweenTwoPrices(min, max);
    }

    @Override
    public List<ProductsCatalogEntity> findByCategoryName(BigInteger id) {
        return List.of();
    }

    @Override
    public List<ProductsCatalogEntity> findByBrandAndRating(String brand, Short rating) {
        return List.of();
    }

    @Override
    public Page<ProductsCatalogEntity> findAll(String field, Boolean desc) {
        return null;
    }

    @Override
    public Page<ProductsCatalogEntity> findAllByBrand(String brand) {
        return null;
    }

    @Override
    public Integer countByBrand(String brand) {
        return 0;
    }
}
