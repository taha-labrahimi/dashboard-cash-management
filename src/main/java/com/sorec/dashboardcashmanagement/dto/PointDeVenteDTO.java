package com.sorec.dashboardcashmanagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PointDeVenteDTO implements Serializable {
    private Long id;
    private String nom;
    private VilleDTO ville;
    //private List<VersementDTO> versements;
}
