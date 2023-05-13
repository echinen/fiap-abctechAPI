package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.implementation.OrderApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class OrderControllerTest {
    private OrderController orderController;

    @MockBean
    private OrderApp orderApp;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(orderApp);
    }

    @Test
    public void test_create_order() throws Exception {
        // Mock data
        OrderDto orderDto = new OrderDto();

        // Call the method
        ResponseEntity<String> responseEntity = orderController.create(orderDto);

        // Verify the response
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNull(responseEntity.getBody());

        // Verify
        Mockito.verify(orderApp).createOrder(orderDto);
    }
}
