package com.example.back_senac_lanches.exception;

import com.example.back_senac_lanches.domain.Question;

public class QuestionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QuestionException(String message) {
        super(message);
    }
}
