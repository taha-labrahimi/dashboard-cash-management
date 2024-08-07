package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.model.PointDeVente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PointDeVenteMapper implements EntityMapper<PointDeVente, PointDeVenteDTO>{


    @Override
    public PointDeVenteDTO toDto(PointDeVente entity) {
        PointDeVenteDTO pointDeVenteDTO = new PointDeVenteDTO();
        pointDeVenteDTO.setId(entity.getId());
        pointDeVenteDTO.setNom(entity.getNom());
        pointDeVenteDTO.setVille(new VilleMapper().toDto(entity.getVille()));
        return  pointDeVenteDTO;
    }

    @Override
    public List<PointDeVenteDTO> toDtos(List<PointDeVente> entities) {
        return  entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PointDeVente toEntity(PointDeVenteDTO dto) {
        return null;
    }

    @Override
    public List<PointDeVente> toEntities(List<PointDeVenteDTO> dtos) {
        return null;
    }
}
