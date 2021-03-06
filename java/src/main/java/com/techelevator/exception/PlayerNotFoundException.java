package com.techelevator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)


public class PlayerNotFoundException extends Exception {


    public PlayerNotFoundException(String message) {super(message);}

    public PlayerNotFoundException(){ this("Player not found.");}



}
