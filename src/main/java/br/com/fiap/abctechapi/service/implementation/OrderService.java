package br.com.fiap.abctechapi.service.implementation;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import br.com.fiap.abctechapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IAssistanceRepository assistanceRepository;
    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IAssistanceRepository assistanceRepository, IOrderRepository orderRepository) {
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> assists) throws Exception {
        ArrayList<Assistance> assistanceList = new ArrayList<>();
        assists.forEach(id -> {
            Assistance assistance = assistanceRepository.findById(id).orElseThrow();
        });

        if (assistanceList.isEmpty()) {
            throw new Exception();
        }

        order.setAssists(assistanceList);

        orderRepository.save(order);
    }
}
