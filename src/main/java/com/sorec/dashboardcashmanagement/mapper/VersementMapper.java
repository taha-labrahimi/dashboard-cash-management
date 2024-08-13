package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.VersementDTO;
import com.sorec.dashboardcashmanagement.model.Versement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VersementMapper implements EntityMapper<Versement, VersementDTO>{

    @Override
    public VersementDTO toDto(Versement entity) {
        VersementDTO versementDTO = new VersementDTO();
        versementDTO.setId(entity.getId());
        versementDTO.setMontant(entity.getMontant());
        versementDTO.setDate(entity.getDate());
        versementDTO.setStatut(entity.getStatut());
        versementDTO.setPointDeVente(new PointDeVenteMapper().toDto(entity.getPointDeVente()));
        return  versementDTO;
    }


    @Override
    public List<VersementDTO> toDtos(List<Versement> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    @Override
    public Versement toEntity(VersementDTO dto) {
        if(dto == null){
            return null;
        }
        Versement versement = new Versement();
        versement.setId(dto.getId());
        versement.setMontant(dto.getMontant());
        versement.setDate(dto.getDate());
        versement.setStatut(dto.getStatut());
        versement.setPointDeVente(new PointDeVenteMapper().toEntity(dto.getPointDeVente()));
        return versement;
    }

    @Override
    public List<Versement> toEntities(List<VersementDTO> dtos)
    {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
