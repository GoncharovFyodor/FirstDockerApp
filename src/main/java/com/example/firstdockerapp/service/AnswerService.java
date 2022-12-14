package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer findBy(Integer id);
    List<Answer> findAll();
    void save(Answer answer);
    void update(Answer answer,Integer id);
    void delete(Integer id);
}
