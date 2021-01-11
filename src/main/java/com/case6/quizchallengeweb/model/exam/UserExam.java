package com.case6.quizchallengeweb.model.exam;

import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UserExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double result; 

    @ManyToOne
    @JoinColumn(name = "appUser")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "exam")
    private Exam exam;

    @OneToMany(mappedBy = "userExam", cascade = CascadeType.ALL)
    private Set<UserAnswer> userAnswers;
}
