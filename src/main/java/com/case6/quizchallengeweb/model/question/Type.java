package com.case6.quizchallengeweb.model.question;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Question> questions;
}
