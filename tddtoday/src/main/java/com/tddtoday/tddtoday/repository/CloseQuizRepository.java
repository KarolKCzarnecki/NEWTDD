package com.tddtoday.tddtoday.repository;

import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CloseQuizRepository extends JpaRepository<CloseQuizEntity, Long> {
}
