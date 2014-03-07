package com.ssda.queue;


public class JobNotFoundException extends RuntimeException {

    private final String message;

    public JobNotFoundException(String message) {
        this.message = message;
    }
}
