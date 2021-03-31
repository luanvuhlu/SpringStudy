package com.case6.quizchallengeweb.service.question.category;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.repository.question.CategoryRepository;
import com.case6.quizchallengeweb.service.question.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QuestionService questionService;


    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


    @Override
    public void delete(Long id) {
        List<Question> questions = questionService.findAllQuestionByCategory_Id(categoryRepository.findById(id).get());
        for (Question question :questions
                ) {
            question.setCategory(null);
        }

        categoryRepository.deleteById(id);

    }
}
