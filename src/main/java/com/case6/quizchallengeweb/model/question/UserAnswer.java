package com.case6.quizchallengeweb.model.question;

import com.case6.quizchallengeweb.model.exam.UserExam;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private int questionIndex;

    @ManyToOne
    @JoinColumn(name = "userExam")
    private UserExam userExam;
}
