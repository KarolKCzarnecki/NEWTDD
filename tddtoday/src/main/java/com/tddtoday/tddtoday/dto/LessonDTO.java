package com.tddtoday.tddtoday.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LessonDTO {

    @NotBlank(message = "Field 'lessonName' -> cannot be blank")
    private String lessonName;

    @NotBlank(message = "Field 'lessonContent' -> cannot be blank")
    private String lessonContent;
}
