package com.example.DPS.Instiute.controller;

import com.example.DPS.Instiute.dto.request.RequestDto;
import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.service.BranchService;
import com.example.DPS.Instiute.utility.PaginatedResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> createBranch(@Valid @RequestBody RequestDto requestDto) {
        ResponseDto save = branchService.createBranch(requestDto);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getBranches(@PathVariable Long id){
        ResponseDto responseDto = branchService.getBranch(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
    @GetMapping("/branches/specification")
    public ResponseEntity<PaginatedResponse<ResponseDto>> getBranches(
            @RequestParam(required = false) String searchStr,
            @RequestParam Long instituteId,
            @RequestParam Long countryId,
            @RequestParam Long stateId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String orderBy,
            @RequestParam(defaultValue = "asc") String sortB) {

        PaginatedResponse<ResponseDto> branches = branchService.getBranchesList(searchStr, instituteId, countryId, stateId, page, pageSize, orderBy, sortB);
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
    @GetMapping("/jpa")
    public ResponseEntity<PaginatedResponse<ResponseDto>> fetchBranches(
            @RequestParam(required = false) String searchStr,
            @RequestParam Long instituteId,
            @RequestParam Long countryId,
            @RequestParam Long stateId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "createdDate") String orderBy,
            @RequestParam(defaultValue = "asc") String sortB){
        PaginatedResponse<ResponseDto> branches = branchService.fetchBranches(searchStr,instituteId,countryId,stateId,page,pageSize,orderBy,sortB);
        return new ResponseEntity<>(branches,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateBranch(@PathVariable Long id,@RequestBody RequestDto requestDto){
        ResponseDto response = branchService.updateBranch(requestDto,id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id){
        String a = "Deleted Branch Successfully";
        branchService.deleteBranch(id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }

}
