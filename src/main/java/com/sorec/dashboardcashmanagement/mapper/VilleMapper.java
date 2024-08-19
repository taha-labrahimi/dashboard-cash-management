package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.VilleDTO;
import com.sorec.dashboardcashmanagement.model.Ville;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class VilleMapper implements EntityMapper<Ville, VilleDTO>{

    @Override
    public VilleDTO toDto(Ville entity) {
        VilleDTO villeDTO = new VilleDTO();
        villeDTO.setId(entity.getId());
        villeDTO.setNom(entity.getNom());
        return villeDTO;
    }

    @Override
    public List<VilleDTO> toDtos(List<Ville> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    @Override
    public Ville toEntity(VilleDTO dto) {
        if (dto==null)
        {
            return null;
        }
        Ville ville = new Ville();
        ville.setId(dto.getId());
        ville.setNom(dto.getNom());
        return ville;
    }

    @Override
    public List<Ville> toEntities(List<VilleDTO> dtos) {
        return Collections.emptyList();
    }
}
