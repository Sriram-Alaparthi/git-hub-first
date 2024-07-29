package com.example.DPS.Instiute.entity;

import com.example.DPS.Instiute.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mse_branches")
public class BranchEntity extends BaseEntity {

    private String name;
    private String code;
    private String affiliationNo;
    private String trustName;
    private String email;
    private String phone;
    private String address;
    private int pinCode;
    private String webSiteUrl;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity countryEntity;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private StateEntity stateEntity;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity instituteEntity;
}
