package com.case6.quizchallengeweb.service.question.question;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IQuestionService extends IService<Question> {
    List<Question> findAllQuestionByCategory_Id (Category category);
    public Question disableQuestion(long id);
}
