package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.ProductsCatalogEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductCatalogRepository extends CrudRepository<ProductsCatalogEntity, UUID> {
}
