package com.example.back_senac_lanches.repository;

import com.example.back_senac_lanches.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
