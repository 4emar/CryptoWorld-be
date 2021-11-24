package com.crypto.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoinNotFoundException extends RuntimeException{
    public CoinNotFoundException(String id){
        super(String.format("Coin with id %s not found", id));
    }
}
