package com.tddtoday.tddtoday.service.impl;



import com.tddtoday.tddtoday.dto.LessonDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.entity.LessonEntity;
import com.tddtoday.tddtoday.exception.LessonNotFoundException;
import com.tddtoday.tddtoday.mapper.LessonMapper;
import com.tddtoday.tddtoday.repository.LessonRepository;
import com.tddtoday.tddtoday.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;


    @Override
    public void addLesson(LessonDTO lessonDTO) {

        CloseQuizEntity closeQuizEntity = lessonMapper.mapToCloseQuizEntity(lessonDTO);

        lessonRepository.save(closeQuizEntity);
    }

    @Override
    public void deleteLessonById(long id) {
        Optional<LessonEntity> lessonEntityOptional = lessonRepository.findById(id);

        lessonEntityOptional.orElseThrow(
                () -> new LessonNotFoundException("Lesson with id: %d not found"
                        .formatted(id)));

        lessonRepository.deleteById(id);
    }

    @Override
    public LessonEntity getLessonById(long id) {
        return lessonRepository.findById(id).orElseThrow(
                () -> new LessonNotFoundException("Lesson with id: %d not found".formatted(id)));
    }


}
