package com.example.back_senac_lanches.domain;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    public Question() {

    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public Question(Long questionId, String question, String answer) {
        this(question, answer);
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
