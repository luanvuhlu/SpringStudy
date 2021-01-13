package com.case6.quizchallengeweb.service.question.question;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.repository.question.CategoryRepository;
import com.case6.quizchallengeweb.repository.question.QuestionRepository;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAllQuestionByCategory_Id(Category category) {
        Iterable<Question> questions1 = questionRepository.getAllByCategoryIs(category);
        List<Question> questions2 = new ArrayList<>();
        for (Question question : questions1
        ) {
            questions2.add(question);
        }
        return questions2;
    }

    @Override
    public Question disableQuestion(long id) {
        Question disableQuestion = questionRepository.findById(id).get();
        if (disableQuestion.getAnswers().size() != 0) {
            return questionRepository.findById(id).get();
        } else {
            disableQuestion.setActive(false);
            questionRepository.save(disableQuestion);
            return disableQuestion;
        }

    }

    @Override
    public Question updateQuestion(long id) {
        List<Question> questions = questionRepository.findAll();
        if (questions.contains(questionRepository.findById(id))) {
            questionRepository.save(questionRepository.findById(id).get());
            return questionRepository.findById(id).get();
        }
        return null;
    }



}
