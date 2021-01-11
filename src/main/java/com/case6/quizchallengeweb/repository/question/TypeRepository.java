package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.question.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
