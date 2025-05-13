package com.jpamodulospring.controller;

import com.jpamodulospring.dtos.OrderDTO;
import com.jpamodulospring.service.OrdersCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "order/")
public class OrderController {

    private final OrdersCrudService orderCrudService;

    @GetMapping(path = "id/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(this.orderCrudService.read(id));
    }

}
