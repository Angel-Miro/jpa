package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductsCatalogEntity, UUID> {
    Optional<ProductsCatalogEntity> findByName(String name);
}
