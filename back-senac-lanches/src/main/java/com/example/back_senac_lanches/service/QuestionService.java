package com.example.back_senac_lanches.service;

import com.example.back_senac_lanches.domain.Question;
import com.example.back_senac_lanches.dtos.QuestionDTO;
import com.example.back_senac_lanches.exception.QuestionException;
import com.example.back_senac_lanches.repository.QuestionRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO, question);
        return questionRepository.save(question);
    }


    public List<Question> findFAQ() {
        return questionRepository.findAll(Sort.by(Sort.Direction.ASC, "questionId"));
    }


    public Question removeQuestion(Long questionId) {
        if(questionId == null) {
            throw new QuestionException("Id was not identified!");
        }
        Question question = questionRepository.findAll().stream().filter(q -> q.getQuestionId() == questionId).findAny().orElseThrow(() -> new QuestionException("Question was not found"));
        questionRepository.deleteById(questionId);
        return question;
    }



}
