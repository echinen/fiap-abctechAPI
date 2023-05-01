package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximunAssistRequiredException;
import br.com.fiap.abctechapi.handler.exception.MinimunAssistRequiredException;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.repository.IOrderRepository;
import br.com.fiap.abctechapi.service.implementation.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

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
        Mockito.when(assistanceRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assistance(1L,"test", "description test")));
    }

    @Test
    public void create_order_error_min_assist() {
        Order newOrder = new Order();
        newOrder.setOperatorId(123L);
        Assertions.assertThrows(MinimunAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_max_assist() {
        Order newOrder = new Order();
        newOrder.setOperatorId(123L);
        Assertions.assertThrows(MaximunAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L)));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }


    // TODO: CENARIO CRIANDO ORDER
}
