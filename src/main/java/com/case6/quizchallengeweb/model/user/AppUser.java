package com.case6.quizchallengeweb.model.user;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

    @OneToMany
    @JsonIgnore
    private Set<UserExam> userExams;
}
