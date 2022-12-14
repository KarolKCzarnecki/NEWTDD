package com.tddtoday.tddtoday.mapper.impl;



import com.tddtoday.tddtoday.dto.LessonDTO;
import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.LessonEntity;
import com.tddtoday.tddtoday.entity.UserEntity;
import com.tddtoday.tddtoday.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j
@Component
@RequiredArgsConstructor
public class LessonMapperImpl implements LessonMapper {
    private final ObjectMapper objectMapper;


    @Override
    public LessonEntity mapToLessonEntity(LessonDTO lessonDTO) {
        log.info("Trying to map UserDTO -> UserEntity");
        return objectMapper.convertValue(lessonDTO, LessonEntity.class);
    }

}
