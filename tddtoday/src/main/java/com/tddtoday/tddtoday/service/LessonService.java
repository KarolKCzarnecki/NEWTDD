package com.tddtoday.tddtoday.service;

import com.tddtoday.tddtoday.dto.LessonDTO;
import com.tddtoday.tddtoday.entity.LessonEntity;

public interface LessonService {

    void addLesson(LessonDTO lessonDTO);

    void deleteLessonById(long id);

    LessonEntity getLessonById(long id);
}
