package com.jpamodulospring.repositories;

import com.jpamodulospring.dtos.ReportProduct;
import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.entities.enums.DateEval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductsCatalogEntity, UUID> {

    Optional<ProductsCatalogEntity> findByName(String name);

    List<ProductsCatalogEntity> findByNameLike(String name);

    @Query("from ProductsCatalogEntity p where p.price between :min and :max")
    List<ProductsCatalogEntity> findByBetweenTwoPrices(BigDecimal min, BigDecimal max);

    List<ProductsCatalogEntity> findByLaunchDateBefore(LocalDate launchDateBefore);

    List<ProductsCatalogEntity> findByLaunchDateAfter(LocalDate launchDateBefore);

    List<ProductsCatalogEntity> findByBrandAndRating(String brand, Short rating);

    List<ProductsCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short ratingIsGreaterThan);

    List<ProductsCatalogEntity> findByBrandAndRatingLessThan(String brand, Short ratingIsLessThan);

    List<ProductsCatalogEntity> findByBrandOrRating(String brand, Short rating);

    @Query("select new com.jpamodulospring.dtos.ReportProduct(" + "pc.brand," +
                                                                  "avg(pc.price)," +
                                                                  "sum(pc.price))" +
            "from ProductsCatalogEntity pc where pc.brand = :brand  group by pc.brand")
    List<ReportProduct> findReportByBrand(String brand);

    @Procedure(procedureName = "count_total_products_by_brand", outputParameterName = "response")
    Integer countTotalProductByBrand(@Param(value = "brand") String brand);

}
