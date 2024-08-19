package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.model.PointDeVente;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return  entities.stream().map(this::toDto).toList();
    }

    @Override
    public PointDeVente toEntity(PointDeVenteDTO dto) {
        if(dto == null){
            return null;
        }
        PointDeVente pointDeVente = new PointDeVente();
        pointDeVente.setId(dto.getId());
        pointDeVente.setNom(dto.getNom());
        pointDeVente.setVille(new VilleMapper().toEntity(dto.getVille()));
        return pointDeVente;
    }

    @Override
    public List<PointDeVente> toEntities(List<PointDeVenteDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
