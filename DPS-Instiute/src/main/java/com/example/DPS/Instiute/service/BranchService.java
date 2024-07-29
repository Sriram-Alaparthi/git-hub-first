package com.example.DPS.Instiute.service;

import com.example.DPS.Instiute.dto.request.RequestDto;
import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.entity.BranchEntity;
import com.example.DPS.Instiute.utility.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BranchService {
    public ResponseDto createBranch(RequestDto requestDto);
    public ResponseDto getBranch(Long id);
    public PaginatedResponse<ResponseDto> getBranchesList(String searchStr, Long instituteId, Long countryId, Long stateId,int page,int pageSize,String orderBy,String sortB);
    public PaginatedResponse<ResponseDto> fetchBranches(String searchStr, Long instituteId, Long countryId, Long stateId,int page, int pageSize, String orderBy, String sortDirection);
    public ResponseDto updateBranch(RequestDto requestDto,Long id);
    public void deleteBranch(Long branchId);
}
