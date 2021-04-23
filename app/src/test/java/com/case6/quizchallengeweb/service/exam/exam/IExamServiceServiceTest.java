package com.case6.quizchallengeweb.service.exam.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.repository.exam.ExamRepository;
import com.case6.quizchallengeweb.repository.exam.UserExamRepository;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.question.IQuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class IExamServiceServiceTest {

	@MockBean
	private UserExamRepository userExamRepository;
	
	@MockBean
	private ExamRepository examRepository;

	@Autowired
	private IExamService examService;
	
	@Autowired
	private IUserExamService userExamService;
	
	@Autowired
	private IQuestionService questionService;

	@Test
	@Rollback
	public void testGetAllExamByUserIdOneValid() {
		UserExam userExam = new UserExam();
		Exam exam1 = new Exam();
		exam1.setId(1L);
		exam1.setName("Exam");
		exam1.setDate(new Date());
		exam1.setCountDown(360);
		exam1.setExamQuestions(Collections.emptySet());
		Set<UserExam> userExam1s = new HashSet<>();
		userExam1s.add(userExam);
		exam1.setUserExams(userExam1s);
		userExam.setExam(exam1);
		Exam exam2 = new Exam();
		exam2.setId(2L);
		exam2.setName("Exam 2");
		exam2.setDate(new Date());
		exam2.setCountDown(360);
		exam2.setExamQuestions(Collections.emptySet());
		UserExam userExam2 = new UserExam();
		Set<UserExam> userExam2s = new HashSet<>();
		userExam2s.add(userExam2);
		exam2.setUserExams(userExam2s);
		userExam2.setExam(exam2);
		List<Exam> expectedExams = Arrays.asList(exam1, exam2);
		when(userExamRepository.getAllByAppUserId(1l)).thenReturn(Arrays.asList(userExam, userExam2));
		List<Exam> actualExams = examService.getAllExamByUserId(1l);
		assertEquals(expectedExams, actualExams);
	}
	
	@Test(expected = Exception.class)
	public void testGetAllExamByUserIdNull() {
		examService.getAllExamByUserId(null);
	}
	
	@Test
	public void testGetAllExamByUserIdEmpty() {
		when(userExamRepository.getAllByAppUserId(1l)).thenReturn(Collections.emptyList());
		List<Exam> actualExams = examService.getAllExamByUserId(1l);
		assertEquals(actualExams.size(), 0);
	}
	
	@Test
	public void testGetAllTestedExamsEmpty() {
		when(examRepository.findAll()).thenReturn(Collections.emptyList());
		List<Exam> actualExams = examService.getAllTestedExams();
		assertEquals(actualExams.size(), 0);
	}
	
	@Test
	@Rollback
	public void testGetAllTestedExamsValid() {
		Exam exam1 = new Exam(1L, "exam 1", 720, new Date());
		Exam exam2 = new Exam(2L, "exam 2", 360, new Date());
		AppUser appUser = new AppUser(2L);
		UserExam userExam1 = new UserExam(1L, new Date(), appUser, exam1);
		UserExam userExam2 = new UserExam(2L, new Date(), appUser, exam1);
		UserExam userExam3 = new UserExam(3L, new Date(), appUser, exam2);
		UserExam userExam4 = new UserExam(4L, new Date(), appUser, exam2);
		examService.save(exam1);
		examService.save(exam2);
		userExamService.save(userExam1);
		userExamService.save(userExam2);
		userExamService.save(userExam3);
		userExamService.save(userExam4);
		List<Exam> expectedExams = Arrays.asList(exam1, exam2);
//		when(examRepository.findAll()).thenReturn(expectedExams);
		List<Exam> actualExams = examService.getAllTestedExams();
		assertEquals(expectedExams, actualExams);
	}
}
