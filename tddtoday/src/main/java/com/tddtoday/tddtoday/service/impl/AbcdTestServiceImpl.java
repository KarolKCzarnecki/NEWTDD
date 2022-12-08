package com.tddtoday.tddtoday.service.impl;

import com.tddtoday.tddtoday.dto.AbcdTestDTO;
import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.exception.AbcdTestNotFoundException;
import com.tddtoday.tddtoday.mapper.AbcdTestMapper;
import com.tddtoday.tddtoday.repository.AbcdTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AbcdTestServiceImpl {


    private final AbcdTestRepository abcdTestRepository;


    private final AbcdTestMapper abcdTestMapper;


    @Override
    public void addAbcdTest(AbcdTestDTO abcdTestDTO) {

        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);

        abcdTestRepository.save(abcdTestEntity);
    }

    @Override
    public void deleteAbcdTestById(long idAbcdTest) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(idAbcdTest);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(idAbcdTest)));

        abcdTestRepository.deleteAbcdTestById(idAbcdTest);
    }

    @Override
    public AbcdTestEntity getAbcdTestById(long idAbcdTest) {
        return abcdTestRepository.findAbcdTestById(idAbcdTest).orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found".formatted(idAbcdTest)));
    }
//
}
