package com.doctorhoai.favourite_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND)
public class FavouriteNotFound extends RuntimeException{
    public FavouriteNotFound( String message){
        super(message);
    }
}
