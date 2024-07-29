package com.example.DPS.Instiute.entity;

import com.example.DPS.Instiute.common.BaseEntity;
import com.example.DPS.Instiute.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mse_institutes")
public class InstituteEntity extends BaseEntity {
    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity countryEntity;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private StateEntity stateEntity;

}
