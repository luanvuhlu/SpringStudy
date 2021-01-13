package com.case6.quizchallengeweb.model.exam;

import com.case6.quizchallengeweb.model.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String countDown;

    @JsonIgnore
    @ManyToMany
    @JoinTable
    private Set<Question> questions = new HashSet<>();

    @UpdateTimestamp
    private Date date;

    @OneToMany(mappedBy = "exam")
    private Set<UserExam> userExams;
}
