package com.jpamodulospring.controller;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import com.jpamodulospring.entities.enums.LikeKey;
import com.jpamodulospring.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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


}
