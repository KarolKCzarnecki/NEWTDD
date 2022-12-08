package com.tddtoday.tddtoday.mapper;


import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;

public interface CloseQuizMapper {

    CloseQuizEntity mapToCloseQuizEntity(CloseQuizDTO closeQuizDTO);
}
