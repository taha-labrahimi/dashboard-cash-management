package com.sorec.dashboardcashmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CanalDTO implements Serializable{

    private Long id;
    private String type;
    private  Double montant;
    private Long pointDeVenteCount;
    private Double sumMontant;
    private String image;
    private List<VersementDTO> versements;
    public CanalDTO() {}
    public CanalDTO(String type, Long pointDeVenteCount) {
        this.type = type;
        this.pointDeVenteCount = pointDeVenteCount;
    }
    public CanalDTO(String type, Double sumMontant, Long pointDeVenteCount,String image) {
        this.type = type;
        this.sumMontant = sumMontant;
        this.pointDeVenteCount = pointDeVenteCount;
        this.image = image;
    }
}
