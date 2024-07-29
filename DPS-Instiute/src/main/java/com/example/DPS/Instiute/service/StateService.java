package com.example.DPS.Instiute.service;

import com.example.DPS.Instiute.dto.request.StateDto;
import com.example.DPS.Instiute.entity.StateEntity;

public interface StateService {
    public Long createState(StateDto stateDto);
}
