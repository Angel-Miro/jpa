package com.jpamodulospring.controller;

import com.jpamodulospring.dtos.ReportProduct;
import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.entities.enums.DateEval;
import com.jpamodulospring.entities.enums.LikeKey;
import com.jpamodulospring.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "product-catalog/")
@RequiredArgsConstructor
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductsCatalogEntity> getById(@PathVariable String id){
        return ResponseEntity.ok(this.productCatalogService.findById(UUID.fromString(id)));
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<ProductsCatalogEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.productCatalogService.findByName(name));
    }

    @GetMapping(path = "like/{likeKey}")
    public ResponseEntity<List<ProductsCatalogEntity>> getByNameLike(@PathVariable LikeKey likeKey, @RequestParam String name){
        return ResponseEntity.ok(this.productCatalogService.findNameLike(likeKey, name));
    }

    @GetMapping(path = "between")
    public ResponseEntity<List<ProductsCatalogEntity>> getBetweenPrice(@RequestParam BigDecimal min,
                                                                 @RequestParam BigDecimal max){
        return ResponseEntity.ok(this.productCatalogService.findBetweenPrice(min, max));
    }


    @GetMapping(path = "before-date/{date}")
    public ResponseEntity<List<ProductsCatalogEntity>> getByLaunchDateBefore(@PathVariable LocalDate date){
        return ResponseEntity.ok(this.productCatalogService.findByLaunchDateBefore(date));
    }

    @GetMapping(path = "after-date/{date}")
    public ResponseEntity<List<ProductsCatalogEntity>> getByLaunchDateAfter(@PathVariable LocalDate date){
        return ResponseEntity.ok(this.productCatalogService.findByLaunchDateAfter(date));
    }

    @GetMapping(path = "date/{dateEval}")
    public ResponseEntity<List<ProductsCatalogEntity>> getByLaunchDateBoth(@PathVariable DateEval dateEval,
                                                                            @RequestParam LocalDate date){
        return ResponseEntity.ok(this.productCatalogService.findByLaunchDateBoth(dateEval, date));
    }

    @GetMapping(path = "brand-and-rating")
    public ResponseEntity<List<ProductsCatalogEntity>> getByBrandAndRating(@RequestParam String brand,
                                                                           @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandAndRating(brand, rating));
    }

    @GetMapping(path = "brand-and-rating-greater")
    public ResponseEntity<List<ProductsCatalogEntity>> getByBrandAndRatingGreaterThan(@RequestParam String brand,
                                                                           @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandAndRatingGreaterThan(brand, rating));
    }

    @GetMapping(path = "brand-and-rating-less")
    public ResponseEntity<List<ProductsCatalogEntity>> getByBrandAndRatingLessThan(@RequestParam String brand,
                                                                           @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandAndRatingLessThan(brand, rating));
    }

    @GetMapping(path = "brand-or-rating")
    public ResponseEntity<List<ProductsCatalogEntity>> getByBrandOrRating(@RequestParam String brand,
                                                                           @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandOrRating(brand, rating));
    }

    @GetMapping(path = "report-by-brand/{brand}")
    public ResponseEntity<List<ReportProduct>> getReportByBrand(@PathVariable String brand){
        return ResponseEntity.ok(this.productCatalogService.findReportByBrand(brand));
    }

    @GetMapping(path = "find-all-pages")
    public ResponseEntity<Page<ProductsCatalogEntity>> getAllPage(@RequestParam(required = false) String field,
                                                                  @RequestParam(required = false) Boolean desc,
                                                                  @RequestParam Integer page){
        return ResponseEntity.ok(this.productCatalogService.findAll(field, desc, page));
    }
}
