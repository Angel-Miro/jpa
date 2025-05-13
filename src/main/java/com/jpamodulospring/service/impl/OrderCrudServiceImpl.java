package com.jpamodulospring.service.impl;

import com.jpamodulospring.dtos.OrderDTO;
import com.jpamodulospring.entities.OrderEntity;
import com.jpamodulospring.repositories.OrderRepository;
import com.jpamodulospring.service.OrdersCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCrudServiceImpl implements OrdersCrudService {

    private final OrderRepository orderRepository;

    @Override
    public String create(OrderDTO order) {
        return "";
    }

    @Override
    public OrderDTO read(Long id) {
        return this.mapOrderFromEntity(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO order, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


    private OrderDTO mapOrderFromEntity(OrderEntity orderEntity) {
        final var mapper = new ModelMapper();
        return mapper.map(orderEntity, OrderDTO.class);
    }
}
