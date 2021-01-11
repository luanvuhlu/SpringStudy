package com.case6.quizchallengeweb.service.question.answer;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.repository.question.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Iterable<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
