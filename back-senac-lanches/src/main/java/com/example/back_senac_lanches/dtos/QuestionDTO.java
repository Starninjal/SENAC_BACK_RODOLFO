package com.example.back_senac_lanches.dtos;

import com.example.back_senac_lanches.domain.Question;

public record QuestionDTO(Long questionId, String question, String answer) {
    public static Question toQuestion(QuestionDTO questionDTO) {
        return new Question(questionDTO.questionId,
                questionDTO.question,
                questionDTO.answer);
    }

    public static QuestionDTO toDTO(Question question) {
        return new QuestionDTO(
                question.getQuestionId(),
                question.getQuestion(),
                question.getAnswer());
    }


}
