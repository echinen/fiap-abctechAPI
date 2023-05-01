package br.com.fiap.abctechapi.handler;

import br.com.fiap.abctechapi.handler.exception.MaximunAssistRequiredException;
import br.com.fiap.abctechapi.handler.exception.MinimunAssistRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimunAssistRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRequired(MinimunAssistRequiredException exception) {
        ErrorMessageResponse error = new ErrorMessageResponse(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaximunAssistRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistRequired(MaximunAssistRequiredException exception) {
        ErrorMessageResponse error = new ErrorMessageResponse(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
