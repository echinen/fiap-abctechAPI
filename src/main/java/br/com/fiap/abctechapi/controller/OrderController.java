package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.implementation.OrderApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderApp orderApp;

    @Autowired
    public OrderController(OrderApp orderApp) {
        this.orderApp = orderApp;
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody OrderDto orderDto) throws Exception {

        this.orderApp.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
}
