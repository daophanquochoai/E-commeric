package com.doctorhoai.user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND)
public class ObjectNotFound extends RuntimeException {
    public ObjectNotFound( String message ){
        super(message);
    }
}
