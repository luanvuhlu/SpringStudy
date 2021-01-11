package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.question.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
}
