package com.example.DPS.Instiute.service.Impl;

import com.example.DPS.Instiute.dto.request.CountryDto;
import com.example.DPS.Instiute.entity.CountryEntity;
import com.example.DPS.Instiute.repository.CountryRepository;
import com.example.DPS.Instiute.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Long saveCountry(CountryDto countryDto) {
        CountryEntity country = new CountryEntity();
        country.setName(countryDto.getName());
        country.setStatus(countryDto.getStatus());
        country.setCreatedDate(LocalDateTime.now());
        CountryEntity country1 = countryRepository.save(country);
        return country.getId();
    }
}
