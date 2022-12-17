package com.tddtoday.tddtoday.mapper.impl;


import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.mapper.CloseQuizMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class CloseQuizMapperImpl implements CloseQuizMapper {


    private final ObjectMapper objectMapper;

    @Override
    public CloseQuizEntity mapToCloseQuizEntity(CloseQuizDTO closeQuizDTO) {
        log.info("Trying to map CloseQuizDTO -> CloseQuizEntity");
        return objectMapper.convertValue(closeQuizDTO, CloseQuizEntity.class);
    }


}
