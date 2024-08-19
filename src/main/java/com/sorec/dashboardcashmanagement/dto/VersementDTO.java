package com.sorec.dashboardcashmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VersementDTO implements Serializable {
    private Long id;
    private Double montant;
    private LocalDate date;
    private String statut;
    private PointDeVenteDTO pointDeVente;
    private Long pointDeVenteCount;
    private Double sumMontant;
    private Double recoveryRate;

    public VersementDTO(String statut, Double sumMontant, Long pointDeVenteCount) {
        this.statut = statut;
        this.pointDeVenteCount = pointDeVenteCount;
        this.sumMontant = sumMontant;
    }

    public VersementDTO() {}

}
