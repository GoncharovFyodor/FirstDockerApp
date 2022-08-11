package com.example.firstdockerapp.exception;

public class QuestionExistException extends RuntimeException {
    public QuestionExistException(String message) {
        super(message);
    }
}
