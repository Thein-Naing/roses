package com.life.roses.exception;

public class RoseNotFoundException extends RuntimeException {

    public RoseNotFoundException(Long id) {
        super ("Rose with given id" + id + " not found");
    }
}
