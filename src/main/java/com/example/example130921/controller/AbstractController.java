package com.example.example130921.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Optional;

public abstract class AbstractController<s> {

    @Autowired
    protected s service;

    protected <T> ResponseEntity<T> response(Optional<T> response) {
        return new ResponseEntity<T>((T) response, HttpStatus.OK);
    }
}