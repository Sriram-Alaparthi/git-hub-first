package com.example.DPS.Instiute.service.Impl;

import com.example.DPS.Instiute.dto.request.RequestDto;
import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.entity.BranchEntity;
import com.example.DPS.Instiute.entity.CountryEntity;
import com.example.DPS.Instiute.entity.InstituteEntity;
import com.example.DPS.Instiute.entity.StateEntity;
import com.example.DPS.Instiute.exception.ResourceAlreayExistsException;
import com.example.DPS.Instiute.exception.ResourceNotFoundException;
import com.example.DPS.Instiute.mapper.BranchMapper;
import com.example.DPS.Instiute.repository.BranchRepository;
import com.example.DPS.Instiute.repository.CountryRepository;
import com.example.DPS.Instiute.repository.InstituteRepository;
import com.example.DPS.Instiute.repository.StateRepository;
import com.example.DPS.Instiute.service.BranchService;
import com.example.DPS.Instiute.utility.PaginatedResponse;
import com.example.DPS.Instiute.utility.Utility;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {


    private final BranchRepository branchRepository;

    private final CountryRepository countryRepository;

    private final InstituteRepository instituteRepository;

    private final StateRepository stateRepository;

    BranchMapper branchMap = BranchMapper.INSTANCE;



    @Override
    public ResponseDto createBranch(RequestDto requestDto) {

        CountryEntity country = countryRepository.findById(requestDto.getCountryId()).orElseThrow(() -> new ResourceNotFoundException("Country not Found with id:" + requestDto.getCountryId()));

        StateEntity state = stateRepository.findByIdAndCountryEntity_Id(Math.toIntExact(requestDto.getStateId()), Math.toIntExact(requestDto.getCountryId()))
                .orElseThrow(() -> new ResourceNotFoundException("State not found with ID: " + requestDto.getStateId() + " in country ID: " + requestDto.getCountryId()));

        InstituteEntity institute = instituteRepository.findByIdAndStateEntity_Id(Math.toIntExact(requestDto.getInstituteId()), Math.toIntExact(requestDto.getStateId()))
                .orElseThrow(() -> new ResourceNotFoundException("Institute not found with ID: " + requestDto.getInstituteId() + " in state ID: " + state.getId()));

        if (branchRepository.existsByNameAndCodeAndInstituteEntity_Id(requestDto.getName(), requestDto.getCode(),requestDto.getInstituteId())) {
            throw new ResourceAlreayExistsException("Resource Already Exists");
        }
        BranchEntity branch = new BranchEntity();
        branch.setName(requestDto.getName());
        branch.setCode(requestDto.getCode());
        branch.setAffiliationNo(requestDto.getAffiliationNo());
        branch.setTrustName(requestDto.getTrustName());
        branch.setEmail(requestDto.getEmail());
        branch.setPhone(requestDto.getPhone());
        branch.setAddress(requestDto.getAddress());
        branch.setPinCode(requestDto.getPinCode());
        branch.setWebSiteUrl(requestDto.getWebSiteUrl());
        branch.setCountryEntity(state.getCountryEntity());
        branch.setStateEntity(state);
        branch.setInstituteEntity(institute);
        branch.setCreatedDate(LocalDateTime.now());

        BranchEntity savedBranch = branchRepository.save(branch);

        return branchMap.toResponseDto(savedBranch);
    }
    @Override
    public ResponseDto getBranch(Long id) {
        BranchEntity branch = branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Branch id is not valid"));
        return branchMap.toResponseDto(branch);
    }

    @Override
    public PaginatedResponse<ResponseDto> getBranchesList(String searchStr, Long instituteId, Long countryId, Long stateId, int page, int pageSize,String orderBy,String sortB) {
        Specification<BranchEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchStr != null && !searchStr.isEmpty()) {
                String lowerSearchStr = "%" + searchStr.toLowerCase() + "%";
                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), lowerSearchStr);
                Predicate codePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("code")), lowerSearchStr);
                predicates.add(criteriaBuilder.or(namePredicate, codePredicate));
            }

            if (instituteId != null && instituteId != 0)
                predicates.add(criteriaBuilder.equal(root.get("instituteEntity").get("id"), instituteId));

            if (countryId != null && countryId != 0)
                predicates.add(criteriaBuilder.equal(root.get("countryEntity").get("id"), countryId));

            if (stateId != null && stateId != 0)
                predicates.add(criteriaBuilder.equal(root.get("stateEntity").get("id"), stateId));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        PageRequest pageable = Utility.pageRequest(page,pageSize,orderBy,sortB);

        Page<BranchEntity> branchPage = branchRepository.findAll(spec, pageable);
        List<ResponseDto> branchDtoList = branchPage.map(branchMap::toResponseDto).getContent();

        return Utility.paginatedResponse(branchPage.getNumber(),
                branchPage.getTotalPages(),
                branchPage.getSize(),
                branchPage.getNumberOfElements(),
                branchPage.getTotalElements(),
                branchPage,
                branchDtoList
        );
    }


    @Override
    public PaginatedResponse<ResponseDto> fetchBranches(String searchStr, Long instituteId, Long countryId, Long stateId,int page,int pageSize,String orderBy,String sortDirection) {
        PageRequest pageable = Utility.pageRequest(page,pageSize,orderBy,sortDirection);
        Page<ResponseDto> branchPage = branchRepository.getBranches(searchStr, instituteId, countryId, stateId,pageable);
        return Utility.paginatedResponse(
                branchPage.getNumber(),
                branchPage.getTotalPages(),
                branchPage.getSize(),
                branchPage.getNumberOfElements(),
                branchPage.getTotalElements(),
                branchPage,
                branchPage.getContent()
        );
    }

    @Override
    public ResponseDto updateBranch(RequestDto requestDto,Long branchId) {
        BranchEntity existingBranch = branchRepository.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("Branch not found with ID: " + branchId));

        CountryEntity country = countryRepository.findById(requestDto.getCountryId()).orElseThrow(() -> new ResourceNotFoundException("Country not Found with id:" + requestDto.getCountryId()));

        StateEntity state = stateRepository.findByIdAndCountryEntity_Id(Math.toIntExact(requestDto.getStateId()), Math.toIntExact(requestDto.getCountryId())).orElseThrow(() -> new ResourceNotFoundException("State not found with ID: " + requestDto.getStateId() + " in country ID: " + requestDto.getCountryId()));

        InstituteEntity institute = instituteRepository.findByIdAndStateEntity_Id(Math.toIntExact(requestDto.getInstituteId()), Math.toIntExact(requestDto.getStateId()))
                .orElseThrow(() -> new ResourceNotFoundException("Institute not found with ID: " + requestDto.getInstituteId() + " in state ID: " + state.getId()));

        if (branchRepository.existsByNameAndCodeAndInstituteEntity_IdAndIdNot(requestDto.getName(), requestDto.getCode(), requestDto.getInstituteId(), branchId)) {
            throw new ResourceAlreayExistsException("Branch with name: " + requestDto.getName() + " and code: " + requestDto.getCode() + " already exists for the institute ID: " + requestDto.getInstituteId());
        }

        if (branchRepository.existsByNameAndCodeAndIdNot(requestDto.getName(), requestDto.getCode(), branchId)) {
            throw new ResourceAlreayExistsException("Branch with name: " + requestDto.getName() + " and code: " + requestDto.getCode() + " already exists");
        }

        existingBranch.setName(requestDto.getName());
        existingBranch.setCode(requestDto.getCode());
        existingBranch.setAffiliationNo(requestDto.getAffiliationNo());
        existingBranch.setTrustName(requestDto.getTrustName());
        existingBranch.setEmail(requestDto.getEmail());
        existingBranch.setPhone(requestDto.getPhone());
        existingBranch.setAddress(requestDto.getAddress());
        existingBranch.setPinCode(requestDto.getPinCode());
        existingBranch.setWebSiteUrl(requestDto.getWebSiteUrl());
        existingBranch.setCountryEntity(state.getCountryEntity());
        existingBranch.setStateEntity(state);
        existingBranch.setInstituteEntity(institute);
        existingBranch.setModifiedDate(LocalDateTime.now());

        BranchEntity updatedBranch = branchRepository.save(existingBranch);

        return branchMap.toResponseDto(updatedBranch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

}
