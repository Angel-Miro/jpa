package com.jpamodulospring.service.impl;

import com.jpamodulospring.dtos.ReportProduct;
import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.entities.enums.DateEval;
import com.jpamodulospring.entities.enums.LikeKey;
import com.jpamodulospring.repositories.ProductCatalogRepository;
import com.jpamodulospring.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductCatalogRepository productCatalogRepository;

    private static final int MAX_PAGE =5;

    @Override
    public ProductsCatalogEntity findById(UUID id) {
        return this.productCatalogRepository.findById(id).orElseThrow();
    }

    @Override
    public ProductsCatalogEntity findByName(String name) {
        return this.productCatalogRepository.findByName(name).orElse(ProductsCatalogEntity.builder().build());
    }

    @Override
    public List<ProductsCatalogEntity> findNameLike(LikeKey key, String word) {
        final var placeholder = "%";

        if(key.equals(LikeKey.AFTER)){
            return this.productCatalogRepository.findByNameLike(placeholder.concat(word));
        }

        if(key.equals(LikeKey.BETWEEN)){
            return this.productCatalogRepository.findByNameLike(placeholder.concat(placeholder.concat(word).concat(placeholder)));
        }

        if(key.equals(LikeKey.BEFORE)){
            return this.productCatalogRepository.findByNameLike(word.concat(placeholder));
        }

        return new ArrayList<>();
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
    public List<ProductsCatalogEntity> findByLaunchDateBefore(LocalDate date) {
        return this.productCatalogRepository.findByLaunchDateBefore(date);
    }

    @Override
    public List<ProductsCatalogEntity> findByLaunchDateAfter(LocalDate date) {
        return this.productCatalogRepository.findByLaunchDateAfter(date);
    }

    @Override
    public List<ProductsCatalogEntity> findByLaunchDateBoth(DateEval eval, LocalDate date) {
        if(eval.equals(DateEval.BEFORE)) {
            return this.productCatalogRepository.findByLaunchDateBefore(date);
        }else {
            return this.productCatalogRepository.findByLaunchDateAfter(date);
        }
    }

    @Override
    public List<ProductsCatalogEntity> findByBrandAndRating(String brand, Short rating) {
        return this.productCatalogRepository.findByBrandAndRating(brand, rating);
    }

    @Override
    public List<ProductsCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short rating) {
        return this.productCatalogRepository.findByBrandAndRatingGreaterThan(brand, rating);
    }

    @Override
    public List<ProductsCatalogEntity> findByBrandAndRatingLessThan(String brand, Short rating) {
        return this.productCatalogRepository.findByBrandAndRatingLessThan(brand, rating);
    }

    @Override
    public List<ProductsCatalogEntity> findByBrandOrRating(String brand, Short rating) {
        return this.productCatalogRepository.findByBrandOrRating(brand, rating);
    }

    @Override
    public List<ReportProduct> findReportByBrand(String brand) {
        return this.productCatalogRepository.findReportByBrand(brand);
    }

    @Override
    public Page<ProductsCatalogEntity> findAll(String field, Boolean desc, Integer page) {
        Sort sort = Sort.by(field);
        return (desc) ? this.productCatalogRepository.findAll(PageRequest.of(page, MAX_PAGE,sort.descending()))
                : this.productCatalogRepository.findAll(PageRequest.of(page, MAX_PAGE, sort.ascending()));
    }

    @Override
    public Integer countByBrand(String brand) {
        return 0;
    }
}
