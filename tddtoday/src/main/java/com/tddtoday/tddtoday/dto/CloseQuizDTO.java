package com.tddtoday.tddtoday.dto;




import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CloseQuizDTO {

    public long id;

    @NotBlank(message = "Field 'question' -> cannot be blank")
    private String question;

    @NotBlank(message = "Field 'answerA' -> cannot be blank")
    private String answerA;

    @NotBlank(message = "Field 'answerB' -> cannot be blank")
    private String answerB;

    @NotBlank(message = "Field 'answerC' -> cannot be blank")
    private String answerC;

    @NotBlank(message = "Field 'answerD' -> cannot be blank")
    private String answerD;

    @NotBlank(message = "Field 'correctAnswer' -> cannot be blank")
    private String correctAnswer;

/// dodane 8.12  ma sprawdzić  czy correct Answer zgadza się z tym co wybierze user
    private boolean result;





}
