package com.tddtoday.tddtoday.service;
import  com.tddtoday.tddtoday.entity.AbcdTestEntity;
import  com.tddtoday.tddtoday.dto.AbcdTestDTO;


public interface AbcdTestService {

    void addAbcdTest(AbcdTestDTO abcdTestDTO);

    void deleteAbcdTestById(long idAbcdTest);

    AbcdTestEntity getAbcdTestById(long idAbcdTest);
}
