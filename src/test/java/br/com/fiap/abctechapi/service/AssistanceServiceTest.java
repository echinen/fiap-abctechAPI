package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.service.implementation.AssistanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {

    private IAssistanceService assistanceService;
    @MockBean
    private IAssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceService(assistanceRepository);
    }

    @Test
    public void test_lista_assistance(){
        Mockito.when(assistanceRepository.findAll())
                .thenReturn(List.of(new Assistance(123L, "Test1", "Test descr 1")));

        List<Assistance> list = assistanceService.getAssistance();

        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.size(), 1);
    }
}
