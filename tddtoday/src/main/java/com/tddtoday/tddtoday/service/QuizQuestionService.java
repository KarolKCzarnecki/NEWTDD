package com.tddtoday.tddtoday.service;

import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.dto.CloseQuizDTO;


public interface QuizQuestionService {

    void addCloseQuiz(CloseQuizDTO closeQuizDTO);

    void deleteById(long id);

    CloseQuizEntity getById(long id);

    //dodane 8.12

//    CloseQuizEntity patchAnswerAById( long id, String answerA);



//    CloseQuizEntity readById(long id);
}
