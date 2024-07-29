package com.example.DPS.Instiute.controller;

import com.example.DPS.Instiute.dto.request.CountryDto;
import com.example.DPS.Instiute.entity.CountryEntity;
import com.example.DPS.Instiute.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/save")
    public ResponseEntity<Long> createCountry(@RequestBody CountryDto countryDto){
        Long a = countryService.saveCountry(countryDto);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }
}
