package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
