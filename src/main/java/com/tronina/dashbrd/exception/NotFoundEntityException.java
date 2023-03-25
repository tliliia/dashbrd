package com.tronina.dashbrd.exception;

public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(Long id) {
        super(String.format("Not found entity with id=%d", id));
    }
}
