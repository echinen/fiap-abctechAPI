package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MaximunAssistRequiredException extends RuntimeException{
    private String description;
    public MaximunAssistRequiredException(String message, String description) {
        super(message);
        this.description = description;
    }
}
