package com.example.DPS.Instiute.mapper;

import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.entity.BranchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    @Mapping(target = "name",source = "name")
    @Mapping(source = "instituteEntity.id",target = "instituteId")
    @Mapping(source = "instituteEntity.name",target = "instituteName")
    @Mapping(source = "code",target = "code")
    @Mapping(source = "affiliationNo",target = "affiliationNo")
    @Mapping(source = "trustName",target = "trustName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "phone",target = "phone")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "pinCode",target = "pinCode")
    @Mapping(source = "countryEntity.id",target = "countryId")
    @Mapping(source = "countryEntity.name",target = "countryName")
    @Mapping(source = "stateEntity.id",target = "stateId")
    @Mapping(source = "stateEntity.name",target = "stateName")
    @Mapping(source = "webSiteUrl",target = "webSiteUrl")
    ResponseDto toResponseDto(BranchEntity branchEntity);

}
