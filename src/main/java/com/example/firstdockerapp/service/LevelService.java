package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Level;

import java.util.List;

public interface LevelService {
    Level findBy(Integer id);
    List<Level> findAll();
    void save(Level level);
    void update(Level level,Integer id);
    void delete(Integer id);
}
