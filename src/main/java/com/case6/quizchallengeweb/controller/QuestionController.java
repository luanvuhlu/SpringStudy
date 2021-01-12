package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.service.question.answer.IAnswerService;
import com.case6.quizchallengeweb.service.question.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IAnswerService answerService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAllCategory() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

}
