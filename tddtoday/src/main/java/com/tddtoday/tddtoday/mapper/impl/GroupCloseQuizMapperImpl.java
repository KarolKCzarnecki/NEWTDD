package com.tddtoday.tddtoday.mapper.impl;


import com.tddtoday.tddtoday.dto.GroupCloseQuizDTO;
import com.tddtoday.tddtoday.entity.GroupCloseQuizEntity;
import com.tddtoday.tddtoday.mapper.CollectionOfAbcdTestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class GroupCloseQuizMapperImpl implements CollectionOfAbcdTestMapper {

    private final ObjectMapper objectMapper;

    @Override
    public GroupCloseQuizEntity mapToCollectionOfAbcdTestEntity(GroupCloseQuizDTO groupCloseQuizDTO) {
        log.info("Trying to map CollectionOfAbcdTestDTO -> CollectionOfAbcdTestEntity");
        return objectMapper.convertValue(groupCloseQuizDTO, GroupCloseQuizEntity.class);
    }

}
