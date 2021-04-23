package com.case6.quizchallengeweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.service.question.answer.IAnswerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answers")
@Slf4j
public class AnswerController {
    @Autowired
    private IAnswerService answerService;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> findAllAnswer(){
        return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        try {
            answerService.save(answer);
            return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
        } catch (Exception e) {
        	log.error("createAnswer error", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        return answerOptional.map(answer -> {
            answerService.delete(id);
            return new ResponseEntity<Answer>(HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
