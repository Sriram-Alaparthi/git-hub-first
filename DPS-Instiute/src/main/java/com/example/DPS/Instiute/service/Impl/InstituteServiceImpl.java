package com.example.DPS.Instiute.service.Impl;

import com.example.DPS.Instiute.entity.InstituteEntity;
import com.example.DPS.Instiute.repository.InstituteRepository;
import com.example.DPS.Instiute.service.InstituteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private InstituteRepository instituteRepository;

    @Override
    public Long createInstitute(InstituteEntity instituteEntity) {
        InstituteEntity institute = instituteRepository.save(instituteEntity);
        return institute.getId();
    }
}
