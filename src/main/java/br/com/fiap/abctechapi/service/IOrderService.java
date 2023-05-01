package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Order;

import java.util.List;

public interface IOrderService {
    void saveOrder(Order order, List<Long> assists);
}
