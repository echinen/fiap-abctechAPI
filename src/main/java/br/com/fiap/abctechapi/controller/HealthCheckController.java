package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.util.VersionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HealthCheckController {
    private final VersionComponent versionComponent;
    public HealthCheckController(@Autowired VersionComponent versionComponent){
        this.versionComponent = versionComponent;
    }

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("It is working (200)!!!");
    }

    @GetMapping("version")
    public ResponseEntity<String> version() throws IOException {
        return ResponseEntity.ok(this.versionComponent.getVersion());
    }
}
