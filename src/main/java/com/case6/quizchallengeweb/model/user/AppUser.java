package com.case6.quizchallengeweb.model.user;

import com.case6.quizchallengeweb.model.exam.UserExam;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullname;

    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

    @OneToMany
    private Set<UserExam> userExams;
}
