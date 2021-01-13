package com.case6.quizchallengeweb.model.question;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;


    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private Set<Answer> answers;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    private Set<Exam> exams = new HashSet<>();
}
