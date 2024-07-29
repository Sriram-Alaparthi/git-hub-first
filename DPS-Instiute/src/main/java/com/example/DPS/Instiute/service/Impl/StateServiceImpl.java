package com.example.DPS.Instiute.service.Impl;

import com.example.DPS.Instiute.dto.request.StateDto;
import com.example.DPS.Instiute.entity.CountryEntity;
import com.example.DPS.Instiute.entity.StateEntity;
import com.example.DPS.Instiute.exception.ResourceNotFoundException;
import com.example.DPS.Instiute.repository.CountryRepository;
import com.example.DPS.Instiute.repository.StateRepository;
import com.example.DPS.Instiute.service.CountryService;
import com.example.DPS.Instiute.service.StateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    private CountryRepository countryRepository;


    @Override
    public Long createState(StateDto stateDto) {
        CountryEntity country = countryRepository.findById(stateDto.getCountryId()).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
        StateEntity savedState = new StateEntity();
        savedState.setName(stateDto.getName());
        savedState.setCreatedDate(LocalDateTime.now());
        savedState.setStatus(savedState.getStatus());
        StateEntity save = stateRepository.save(savedState);

        return save.getId();
    }
}
