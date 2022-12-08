package com.tddtoday.tddtoday.service;


import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.mapper.CloseQuizMapper;
import com.tddtoday.tddtoday.repository.CloseQuizRepository;
import com.tddtoday.tddtoday.service.impl.QuizQuestionServiceImpl;
import com.tddtoday.tddtoday.utils.CloseQuizGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuizQuestionSerivceTest {

    @Mock
    private CloseQuizRepository closeQuizRepository;


    @Mock
    private CloseQuizMapper CLoseQuizMapper;

    @InjectMocks
    private QuizQuestionServiceImpl underTest;

    @Test
    void shouldSaveAbcdTestEntity() {
        // given
        CloseQuizDTO closeQuizDTO = CloseQuizDTO.builder()

                .question("zaznacz poprawną kolejność przebiegu schematu działania TDD")
                .answerA("Faza Zielona, Faza Czerwona, Refakotryzacja")
                .answerB("Faza Czarna, Faza Zielona, Refakotryzacja")
                .answerC("Refaktoryzacja, Faza Zielona, Faza Czarna")
                .answerD("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .correctAnswer("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .result(true).build();


        CloseQuizEntity closeQuizEntity = CloseQuizGenerator.getExampleAbcdTestEntity();
        // when

        when(CLoseQuizMapper.mapToCloseQuizEntity(closeQuizDTO)).thenReturn(closeQuizEntity);
        underTest.addCloseQuiz(closeQuizDTO);

        // then
        ArgumentCaptor<CloseQuizEntity> abcdTestEntityArgumentCaptor = ArgumentCaptor.forClass(CloseQuizEntity.class);

        verify(closeQuizRepository).save(abcdTestEntityArgumentCaptor.capture());

        CloseQuizEntity capturedCloseQuizEntity = abcdTestEntityArgumentCaptor.getValue();

        assertEquals("zaznacz poprawną kolejność przebiegu schematu działania TDD", capturedCloseQuizEntity.getQuestion());
        assertEquals("Faza Zielona, Faza Czerwona, Refakotryzacja", capturedCloseQuizEntity.getAnswerA());
        assertEquals("Faza Czarna, Faza Zielona, Refakotryzacja", capturedCloseQuizEntity.getAnswerB());
        assertEquals("Refaktoryzacja, Faza Zielona, Faza Czarna", capturedCloseQuizEntity.getAnswerC());
        assertEquals("Faza Czerwona, Faza Zielona, Refaktoryzacja", capturedCloseQuizEntity.getAnswerD());
        assertEquals("Faza Czerwona, Faza Zielona, Refaktoryzacja", capturedCloseQuizEntity.getCorrectAnswer());


    }

}
