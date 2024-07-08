package com.example.back_senac_lanches.controller;

import com.example.back_senac_lanches.domain.Question;
import com.example.back_senac_lanches.dtos.QuestionDTO;
import com.example.back_senac_lanches.service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> findFAQ() {
        List<Question> questions = questionService.findFAQ();
        return ResponseEntity.ok(questions.stream().map(QuestionDTO::toDTO).toList());
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> saveFAQ(@RequestBody QuestionDTO questionDTO) {
        Question savedQuestion = questionService.saveQuestion(questionDTO);
        return ResponseEntity.ok(QuestionDTO.toDTO(savedQuestion));
    }

    @PutMapping
    public ResponseEntity<QuestionDTO> updateFAQ(@RequestBody QuestionDTO questionDTO) {
        Question savedQuestion = questionService.saveQuestion(questionDTO);
        return ResponseEntity.ok(QuestionDTO.toDTO(savedQuestion));
    }


    @DeleteMapping("/{questionId}")
    public ResponseEntity<QuestionDTO> deleteFAQ(@PathVariable("questionId") Long questionId) {
        Question deletedQuestion = questionService.removeQuestion(questionId);
        return ResponseEntity.ok(QuestionDTO.toDTO(deletedQuestion));
    }

}
