package com.sorec.dashboardcashmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "VERSEMENT")
public class Versement {
    @Id
    @SequenceGenerator(name="FLUX_IDFLUX_GENERATOR", sequenceName="SEQ_FLUX_TRANSACTION",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="FLUX_IDFLUX_GENERATOR")
    private Long id;
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "DATE_VERSEMENT")
    private LocalDate date;
    @Column(name = "STATUT")
    private String statut;

    @ManyToOne
    @JoinColumn(name = "point_de_vente_id")
    private PointDeVente pointDeVente;

    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;
}
