package com.wsd.ecom.core;

import com.wsd.ecom.exception.AbstractException;
import com.wsd.ecom.exception.ExceptionDetails;
import com.wsd.ecom.exception.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AbstractException ex) {
        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
        log.error("Error in API: ", ex);
        ExceptionResponse response = new ExceptionResponse(status, new ExceptionDetails(status.value(), ex.getMessage()));
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error("Error in App: ", ex);
        ExceptionResponse response = new ExceptionResponse(status, new ExceptionDetails(status.value(), ex.getMessage()));
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(Error.class)
    public ResponseEntity<ErrorResponse> handleError(Error ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error("Error in App: ", ex);
        ExceptionResponse response = new ExceptionResponse(status, new ExceptionDetails(status.value(), ex.getMessage()));
        return ResponseEntity.status(status).body(response);
    }
}
