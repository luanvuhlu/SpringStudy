package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.service.question.answer.IAnswerService;
import com.case6.quizchallengeweb.service.question.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IAnswerService answerService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAllQuestion() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Question> disableQuestion(@RequestParam long id) {
        Question disableQuestion = questionService.disableQuestion(id);
        return new ResponseEntity<>(disableQuestion, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question) {
        Question insertQuestion = questionService.save(question);
        return new ResponseEntity<>(insertQuestion, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestParam long id, @RequestBody Question question) {

        Question question1 = questionService.updateQuestion(id,question);
        if (question1!=null){
            return new ResponseEntity<>(question1, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
