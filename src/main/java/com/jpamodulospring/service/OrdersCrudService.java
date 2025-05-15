package com.jpamodulospring.service;

import com.jpamodulospring.dtos.OrderDTO;

public interface OrdersCrudService {

    String create(OrderDTO order);
    OrderDTO read(Long id);
    OrderDTO readCustome(Long id);
    OrderDTO update(OrderDTO order, Long id);
    void delete(Long id);
}
