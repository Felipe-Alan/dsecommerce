package com.alandev.dsecommerce.controllers.handlers;

import com.alandev.dsecommerce.dto.CustomError;
import com.alandev.dsecommerce.services.exception.DatabaseException;
import com.alandev.dsecommerce.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFoundHandler(ResourceNotFoundException e,
                                                               HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseHandler(DatabaseException e,
                                                               HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        CustomError err = new CustomError(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
