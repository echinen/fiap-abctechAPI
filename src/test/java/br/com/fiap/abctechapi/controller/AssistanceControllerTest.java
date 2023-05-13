package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import br.com.fiap.abctechapi.application.implementation.AssistanceApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AssistanceControllerTest {
    private AssistanceController assistanceController;

    @MockBean
    private AssistanceApp assistanceApp;

    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);
        assistanceController = new AssistanceController(assistanceApp);
    }

    @Test
    public void test_get_assistance() {
        // Mock
        AssistResponseDto assist1 = new AssistResponseDto(1L, "Title 1", "Description 1");
        AssistResponseDto assist2 = new AssistResponseDto(2L, "Title 2", "Description 2");
        List<AssistResponseDto> expectedAssists = Arrays.asList(assist1, assist2);
        Mockito.when(assistanceApp.getAssistance()).thenReturn(expectedAssists);

        // Call the method
        ResponseEntity<List<AssistResponseDto>> responseEntity = assistanceController.getAssistance();

        // Verify the response
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(expectedAssists, responseEntity.getBody());

        // Verify
        Mockito.verify(assistanceApp).getAssistance();
    }
}
