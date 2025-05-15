package com.jpamodulospring.service.impl;

import com.jpamodulospring.repositories.BillRepository;
import com.jpamodulospring.repositories.OrderRepository;
import com.jpamodulospring.service.TransactionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class TransactionalServiceImpl implements TransactionalService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    @Override
    public void executeTransaction(Long id) {
        this.updateOrder(id);
    }

    @Override
    public void updateOrder(Long id) {
        final var order = orderRepository.findById(id).orElseThrow();
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
        this.validProduct(id);
        this.updateBill(order.getBill().getId());

    }

    @Override
    public void updateBill(String id) {
        final var bill = billRepository.findById(id).orElseThrow();
        bill.setRfc(":: TRANSACTION 123 ::");
        billRepository.save(bill);

    }

    @Override
    public void validProduct(Long id) {
        final var order = orderRepository.findById(id).orElseThrow();
        if(order.getProducts().isEmpty()) {
            throw new IllegalStateException("Product not found");
        }
    }
}
