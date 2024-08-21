package com.doctorhoai.order_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND)
public class CartNoptFound extends RuntimeException{
    public CartNoptFound( String message){
        super(message);
    }
}
