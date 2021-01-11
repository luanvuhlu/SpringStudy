package com.case6.quizchallengeweb.service.exam.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.repository.exam.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService implements IExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Iterable<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        examRepository.deleteById(id);
    }
}
