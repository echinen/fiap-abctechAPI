package br.com.fiap.abctechapi.service.implementation;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.IAssistanceRepository;
import br.com.fiap.abctechapi.service.IAssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceService implements IAssistanceService {

    private final IAssistanceRepository assistanceRepository;
    @Autowired
    public AssistanceService(IAssistanceRepository assistanceRepository){
        this.assistanceRepository = assistanceRepository;
    }
    @Override
    public List<Assistance> getAssistance() {
        return this.assistanceRepository.findAll();
    }
}
