package com.sorec.dashboardcashmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CANAL")
public class Canal {
    @Id
    @SequenceGenerator(name="FLUX_IDFLUX_GENERATOR", sequenceName="SEQ_FLUX_TRANSACTION",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="FLUX_IDFLUX_GENERATOR")
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Lob
    @Column(name = "IMAGE")
    private String image;

    @OneToMany(mappedBy = "canal")
    private List<Versement> versements;

}
