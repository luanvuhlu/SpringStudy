package com.case6.quizchallengeweb.model.exam;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int countDown;

    @UpdateTimestamp
    private Date date;

    @OneToMany(mappedBy = "exam")
    private Set<ExamQuestion> examQuestions;

    @OneToMany(mappedBy = "exam")
    @JsonIgnore
    private Set<UserExam> userExams;

    public Exam() {
	}
    
	public Exam(Long id, String name, int countDown, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.countDown = countDown;
		this.date = date;
	}
    
}
