package com.example.DPS.Instiute.entity;

import com.example.DPS.Instiute.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mse_country")
public class CountryEntity extends BaseEntity {

    private String name;
}
