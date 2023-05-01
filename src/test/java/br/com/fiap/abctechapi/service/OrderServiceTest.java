package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import br.com.fiap.abctechapi.service.implementation.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @MockBean
    private IOrderRepository orderRepository;
    @MockBean
    private IAssistanceRepository assistanceRepository;

    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(assistanceRepository, orderRepository);
    }

    // MINIMO ASSISTENCIA > 0
    @Test
    public void create_order_error_min_assist() {
        Order newOrder = new Order();
        newOrder.setOperatorId(123L);
        Assertions.assertThrows(Exception.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    // TODO: MAXIMO ASSISTENCIA <= 15


    // TODO: CENARIO CRIANDO ORDER
}
