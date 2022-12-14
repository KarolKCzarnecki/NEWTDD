package com.tddtoday.tddtoday.controller;


import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.dto.LessonDTO;
import com.tddtoday.tddtoday.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lessons")
public class LessonController {

private final LessonService lessonService;

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delLesson(@PathVariable long id) {
        log.info("Trying to delete lesson with id: {}", id);
        lessonService.deleteLessonById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/addLesson")
    public ResponseEntity<Void> addLesson(@RequestBody @Valid LessonDTO lessonDTO) {
        log.info("Trying to add lesson wit name: {}", lessonDTO.getLessonName());
        lessonService.addLesson(lessonDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }



}
