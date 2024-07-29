package com.example.DPS.Instiute.repository;

import com.example.DPS.Instiute.dto.response.ResponseDto;
import com.example.DPS.Instiute.entity.BranchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BranchRepository extends JpaRepository<BranchEntity,Long>, JpaSpecificationExecutor {
    @Query("SELECT new com.example.DPS.Instiute.dto.response.ResponseDto(" +
            "b.id, b.name, i.id, i.name, b.code, b.affiliationNo, b.trustName, b.email, b.phone, b.address, b.pinCode, " +
            "c.id, c.name, s.id, s.name, b.webSiteUrl) " +
            "FROM BranchEntity b " +
            "JOIN b.instituteEntity i " +
            "JOIN b.countryEntity c " +
            "JOIN b.stateEntity s " +
            "WHERE (:searchStr IS NULL OR b.name LIKE %:searchStr% OR b.code LIKE %:searchStr%) " +
            "AND (:stateId IS NULL OR s.id = :stateId) " +
            "AND (:countryId IS NULL OR c.id = :countryId) " +
            "AND (:instituteId IS NULL OR i.id = :instituteId) ")
    Page<ResponseDto> getBranches(@Param("searchStr") String searchStr,
                                  @Param("instituteId") Long instituteId,
                                  @Param("countryId") Long countryId,
                                  @Param("stateId") Long stateId,
                                  Pageable pageable);




    boolean existsByNameAndCodeAndInstituteEntity_Id(String name, String code, Long id);
    boolean existsByNameAndCodeAndInstituteEntity_IdAndIdNot(String name, String code, Long instituteId, Long id);
    boolean existsByNameAndCodeAndIdNot(String name, String code, Long id);
}
