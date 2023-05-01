package br.com.fiap.abctechapi.application.implementation;

import br.com.fiap.abctechapi.application.IAssistanceApp;
import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import br.com.fiap.abctechapi.service.implementation.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceApp implements IAssistanceApp {
    private final AssistanceService assistanceService;

    @Autowired
    public AssistanceApp(AssistanceService assistanceService){
        this.assistanceService = assistanceService;
    }

    @Override
    public List<AssistResponseDto> getAssistance() {
        List<AssistResponseDto> assistResponseDto = this.assistanceService.getAssistance()
                .stream()
                .map(it -> new AssistResponseDto(it.getId(), it.getName(), it.getDescription()))
                .collect(Collectors.toList());
        return assistResponseDto;
    }
}
