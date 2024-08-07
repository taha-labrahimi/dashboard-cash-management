package com.sorec.dashboardcashmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "POINT_DE_VENTE")
public class PointDeVente {
    @Id
    @SequenceGenerator(name="FLUX_IDFLUX_GENERATOR", sequenceName="SEQ_FLUX_TRANSACTION",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="FLUX_IDFLUX_GENERATOR")
    private Long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @OneToMany(mappedBy = "pointDeVente")
    private List<Versement> versements;
}
