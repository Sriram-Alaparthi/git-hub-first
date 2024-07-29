package com.example.DPS.Instiute.controller;

import com.example.DPS.Instiute.entity.InstituteEntity;
import com.example.DPS.Instiute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping("/save")
    public ResponseEntity<Long> createInstitute(@RequestBody InstituteEntity instituteEntity){
        Long a = instituteService.createInstitute(instituteEntity);
        return new  ResponseEntity<>(a,HttpStatus.CREATED);
    }
}
