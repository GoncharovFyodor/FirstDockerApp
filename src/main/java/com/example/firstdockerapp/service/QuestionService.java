package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Question;

import java.util.List;

public interface QuestionService {
    Question findBy(Integer id);
    List<Question> findAll();
    void save(Question question);
    void update(Question question,Integer id);
    void delete(Integer id);
}
