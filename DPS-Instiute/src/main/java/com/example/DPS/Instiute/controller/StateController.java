package com.example.DPS.Instiute.controller;

import com.example.DPS.Instiute.dto.request.StateDto;
import com.example.DPS.Instiute.entity.StateEntity;
import com.example.DPS.Instiute.service.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @PostMapping("/save")
    public ResponseEntity<Long> createState(@Valid @RequestBody StateDto stateEntity){
        Long a = stateService.createState(stateEntity);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }
}
