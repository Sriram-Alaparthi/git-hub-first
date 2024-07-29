package com.example.DPS.Instiute.mapper;

import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.entity.BranchEntity;
import com.example.DPS.Instiute.entity.CountryEntity;
import com.example.DPS.Instiute.entity.InstituteEntity;
import com.example.DPS.Instiute.entity.StateEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-20T10:34:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class BranchMapperImpl implements BranchMapper {

    @Override
    public ResponseDto toResponseDto(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        ResponseDto responseDto = new ResponseDto();

        responseDto.setName( branchEntity.getName() );
        responseDto.setInstituteId( branchEntityInstituteEntityId( branchEntity ) );
        responseDto.setInstituteName( branchEntityInstituteEntityName( branchEntity ) );
        responseDto.setCode( branchEntity.getCode() );
        responseDto.setAffiliationNo( branchEntity.getAffiliationNo() );
        responseDto.setTrustName( branchEntity.getTrustName() );
        responseDto.setEmail( branchEntity.getEmail() );
        responseDto.setPhone( branchEntity.getPhone() );
        responseDto.setAddress( branchEntity.getAddress() );
        responseDto.setPinCode( branchEntity.getPinCode() );
        responseDto.setCountryId( branchEntityCountryEntityId( branchEntity ) );
        responseDto.setCountryName( branchEntityCountryEntityName( branchEntity ) );
        responseDto.setStateId( branchEntityStateEntityId( branchEntity ) );
        responseDto.setStateName( branchEntityStateEntityName( branchEntity ) );
        responseDto.setWebSiteUrl( branchEntity.getWebSiteUrl() );
        responseDto.setId( branchEntity.getId() );

        return responseDto;
    }

    private Long branchEntityInstituteEntityId(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        InstituteEntity instituteEntity = branchEntity.getInstituteEntity();
        if ( instituteEntity == null ) {
            return null;
        }
        Long id = instituteEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String branchEntityInstituteEntityName(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        InstituteEntity instituteEntity = branchEntity.getInstituteEntity();
        if ( instituteEntity == null ) {
            return null;
        }
        String name = instituteEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long branchEntityCountryEntityId(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        CountryEntity countryEntity = branchEntity.getCountryEntity();
        if ( countryEntity == null ) {
            return null;
        }
        Long id = countryEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String branchEntityCountryEntityName(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        CountryEntity countryEntity = branchEntity.getCountryEntity();
        if ( countryEntity == null ) {
            return null;
        }
        String name = countryEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long branchEntityStateEntityId(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        StateEntity stateEntity = branchEntity.getStateEntity();
        if ( stateEntity == null ) {
            return null;
        }
        Long id = stateEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String branchEntityStateEntityName(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }
        StateEntity stateEntity = branchEntity.getStateEntity();
        if ( stateEntity == null ) {
            return null;
        }
        String name = stateEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
