package com.case6.quizchallengeweb.controller;
import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.service.question.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<Iterable<Category>>findAllCategory(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Category> insertCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }





}
