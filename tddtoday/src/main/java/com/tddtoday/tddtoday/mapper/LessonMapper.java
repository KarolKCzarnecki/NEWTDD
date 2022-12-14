package com.tddtoday.tddtoday.mapper;


import com.tddtoday.tddtoday.dto.LessonDTO;
import com.tddtoday.tddtoday.entity.LessonEntity;

public interface LessonMapper {

    LessonEntity mapToLessonEntity(LessonDTO lessonDTO);
}
