package com.sorec.dashboardcashmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VilleDTO implements Serializable {
    private Long id;
    private String nom;
    private Double sumMontant;

    public VilleDTO(String nom, Double sumMontant) {
        this.nom = nom;
        this.sumMontant = sumMontant;
    }
    public VilleDTO(){}
}
