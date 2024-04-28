package com.wsd.ecom.exception;

import org.springframework.http.HttpStatus;


public class ObjectNotFoundException extends AbstractException {

    public ObjectNotFoundException() {
        super("Item not found.");
        setStatus(HttpStatus.NOT_FOUND);
    }

    public ObjectNotFoundException(Long id) {
        super("Object not found with ID: " + id);
    }
}
