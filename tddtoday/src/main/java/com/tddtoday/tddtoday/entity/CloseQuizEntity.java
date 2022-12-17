package com.tddtoday.tddtoday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "closeQuizes", schema = "public")
public class CloseQuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String correctAnswer;

    /// 8.12 ma sprawdzić czy correctAnswer matchuje się z tym co wybrał użytkownik
    private boolean result;

    @ManyToOne
    private GroupCloseQuizEntity groupCloseQuizEntity;


}
