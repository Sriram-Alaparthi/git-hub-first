package com.example.DPS.Instiute.service;

import com.example.DPS.Instiute.dto.request.CountryDto;
import com.example.DPS.Instiute.entity.CountryEntity;

public interface CountryService {
    public Long saveCountry(CountryDto countryDto);
}
