package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
