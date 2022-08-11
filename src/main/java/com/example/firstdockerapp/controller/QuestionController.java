package com.example.firstdockerapp.controller;

import com.example.firstdockerapp.advice.QuestionRepresentationModel;
import com.example.firstdockerapp.entity.Question;
import com.example.firstdockerapp.service.QuestionService;
import lombok.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionRepresentationModel model;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Question>> findById(@PathVariable Integer id){
        EntityModel<Question> questionModel = model.toModel(questionService.findBy(id));
        return ResponseEntity.ok().body(questionModel);
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> findAll(){
        return ResponseEntity.ok().body(questionService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Question question){
        questionService.save(question);
        return ResponseEntity.ok("Question is added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Question question, @PathVariable Integer id){
        questionService.update(question,id);
        return ResponseEntity.ok("Question is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        questionService.delete(id);
        return ResponseEntity.ok("Question is deleted");
    }
}
