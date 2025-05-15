package com.jpamodulospring.service;

public interface TransactionalService {

    void executeTransaction(Long id);

    void updateOrder(Long id);

    void updateBill(String id);

    void validProduct(Long id);
}
