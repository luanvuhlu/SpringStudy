package com.case6.quizchallengeweb.model.exam;

import com.case6.quizchallengeweb.model.question.Question;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "exam")
    private Set<UserExam> userExams;
}
