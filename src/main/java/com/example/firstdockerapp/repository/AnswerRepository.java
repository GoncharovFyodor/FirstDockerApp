package com.example.firstdockerapp.repository;

import com.example.firstdockerapp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    /*@Override
    <S extends Answer> S save(S entity);

    @Override
    Optional<Answer> findById(Integer integer);*/
}
