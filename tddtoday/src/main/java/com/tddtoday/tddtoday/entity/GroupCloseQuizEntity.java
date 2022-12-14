package com.tddtoday.tddtoday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groupCloseQuizEntity", schema = "public")
public class GroupCloseQuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collectionName;

   private  int countCorrectAnswers;

   private int countAllAnswers;

   private int score;

    @OneToMany(mappedBy = "closeQuizes")
    private List<CloseQuizEntity> closeQuiz;


    @ManyToMany(mappedBy = "users")
    private List<UserEntity>user;


}
