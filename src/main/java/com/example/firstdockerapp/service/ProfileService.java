package com.example.firstdockerapp.service;

import com.example.firstdockerapp.entity.Answer;
import com.example.firstdockerapp.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile findBy(Integer id);
    List<Profile> findAll();
    void save(Profile profile);
    void update(Profile profile,Integer id);
    void delete(Integer id);
}
