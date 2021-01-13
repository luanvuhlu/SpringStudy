package com.case6.quizchallengeweb.model.user;

import com.case6.quizchallengeweb.model.exam.UserExam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullname;

    @ManyToMany
    @JoinTable
    private Set<AppRole> appRoles;

    @OneToMany(mappedBy = "appUser",fetch = FetchType.EAGER)
    private Set<UserExam> userExams;
}
