package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.ProductsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductsEntity, Long> {
}
