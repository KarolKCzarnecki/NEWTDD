package com.tddtoday.tddtoday.service;

import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.dto.CloseQuizDTO;


public interface QuizQuestionService {

    void addCloseQuiz(CloseQuizDTO closeQuizDTO);

    void deleteQuizById(long id);

    CloseQuizEntity getQuizById(long id);



   void  updateQuiz(CloseQuizDTO closeQuizDTO);

//    CloseQuizEntity patchAnswerAById( long id, String answerA);



//    CloseQuizEntity readById(long id);
}
