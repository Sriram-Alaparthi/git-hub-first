package com.example.DPS.Instiute.repository;

import com.example.DPS.Instiute.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<StateEntity, Long> {
    Optional<StateEntity> findByIdAndCountryEntity_Id(int id, int countryId);
}
