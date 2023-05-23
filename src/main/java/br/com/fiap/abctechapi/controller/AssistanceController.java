package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.dto.AssistResponseDto;
import br.com.fiap.abctechapi.application.implementation.AssistanceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/assists")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class AssistanceController {
    private final AssistanceApp assistanceApp;

    @Autowired
    public AssistanceController(AssistanceApp assistanceApp) {
        this.assistanceApp = assistanceApp;
    }

    @GetMapping
    public ResponseEntity<List<AssistResponseDto>> getAssistance() {
        return ResponseEntity.ok(assistanceApp.getAssistance());
    }
}
