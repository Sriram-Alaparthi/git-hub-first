package com.example.DPS.Instiute.repository;

import com.example.DPS.Instiute.entity.InstituteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituteRepository extends JpaRepository<InstituteEntity,Long> {
    Optional<InstituteEntity> findByIdAndStateEntity_Id(int id, int stateId);
}
