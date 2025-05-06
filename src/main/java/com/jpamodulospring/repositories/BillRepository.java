package com.jpamodulospring.repositories;

import com.jpamodulospring.entities.BillEntity;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<BillEntity, String> {
}
