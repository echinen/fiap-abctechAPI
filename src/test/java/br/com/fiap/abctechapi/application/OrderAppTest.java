package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDto;
import br.com.fiap.abctechapi.application.implementation.OrderApp;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.entity.OrderLocation;
import br.com.fiap.abctechapi.service.implementation.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
public class OrderAppTest {
    private IOrderApp orderApp;

    @MockBean
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderApp = new OrderApp(orderService);
    }

    @Test
    public void test_create_order() throws Exception {
        // Mock
        OrderDto orderDto = new OrderDto();
        orderDto.setOperatorId(1L);

        OrderLocationDto startLocationDto = new OrderLocationDto();
        startLocationDto.setLatitude(123.456);
        startLocationDto.setLongitude(789.012);
        startLocationDto.setDate(new Date());
        orderDto.setStart(startLocationDto);

        OrderLocationDto endLocationDto = new OrderLocationDto();
        endLocationDto.setLatitude(345.678);
        endLocationDto.setLongitude(901.234);
        endLocationDto.setDate(new Date());
        orderDto.setEnd(endLocationDto);

        Long[] serviceIds = {1L, 2L, 3L};
        orderDto.setServices(Arrays.asList(serviceIds));

        // Call the method
        orderApp.createOrder(orderDto);

        // Verify
        Order expectedOrder = new Order();
        expectedOrder.setOperatorId(1L);
        expectedOrder.setStartOrderLocation(new OrderLocation(null, 123.456, 789.012, new Timestamp(orderDto.getStart().getDate().getTime())));
        expectedOrder.setEndOrderLocation(new OrderLocation(null, 345.678, 901.234, new Timestamp(orderDto.getEnd().getDate().getTime())));

        Mockito.verify(orderService).saveOrder(expectedOrder, Arrays.asList(serviceIds));
    }
}
