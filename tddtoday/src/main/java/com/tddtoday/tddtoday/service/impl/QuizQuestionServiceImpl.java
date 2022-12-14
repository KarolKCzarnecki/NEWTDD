package com.tddtoday.tddtoday.service.impl;

import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.exception.CloseQuizNotFoundException;
import com.tddtoday.tddtoday.mapper.CloseQuizMapper;
import com.tddtoday.tddtoday.repository.CloseQuizRepository;
import com.tddtoday.tddtoday.service.QuizQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
//import javax.validation.Valid;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class QuizQuestionServiceImpl implements QuizQuestionService {


    private final CloseQuizRepository closeQuizRepository;


    private final CloseQuizMapper closeQuizMapper;


    @Override
    public void addCloseQuiz(CloseQuizDTO closeQuizDTO) {

        CloseQuizEntity closeQuizEntity = closeQuizMapper.mapToCloseQuizEntity(closeQuizDTO);

        closeQuizRepository.save(closeQuizEntity);
    }

    @Override
    public void deleteQuizById(long id) {
        Optional<CloseQuizEntity> abcdTestEntityOptional = closeQuizRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new CloseQuizNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));

        closeQuizRepository.deleteById(id);
    }

    @Override
    public CloseQuizEntity getQuizById(long id) {
        return closeQuizRepository.findById(id).orElseThrow(
                () -> new CloseQuizNotFoundException("Test abcd with id: %d not found".formatted(id)));
    }



    @Override
    public void updateQuiz(CloseQuizDTO closeQuizDTO) {
        CloseQuizEntity closeQuizEntity = closeQuizRepository.findById(closeQuizDTO.id);;
        closeQuizMapper.mapToCloseQuizEntity(closeQuizDTO);
        closeQuizRepository.save(closeQuizEntity);
    }

    // dodane 8.12
//    @Override
//    public CloseQuizEntity patchAnswerAById( long id, String answerA) {
//
//
//        return id, answerA;
//
//    }


}
