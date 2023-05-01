package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MinimunAssistRequiredException extends RuntimeException{
    private String description;
    public MinimunAssistRequiredException(String message, String description) {
        super(message);
        this.description = description;
    }
}
