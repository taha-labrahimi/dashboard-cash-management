package com.sorec.dashboardcashmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "VILLE")
public class Ville {

    @Id
    @SequenceGenerator(name="FLUX_IDFLUX_GENERATOR", sequenceName="SEQ_FLUX_TRANSACTION",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="FLUX_IDFLUX_GENERATOR")
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "ville")
    private List<PointDeVente> pointsDeVente;
}
