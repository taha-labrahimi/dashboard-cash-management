package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.CanalDTO;
import com.sorec.dashboardcashmanagement.model.Canal;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class CanalMapper implements EntityMapper<Canal, CanalDTO>{



    @Override
    public CanalDTO toDto(Canal entity) {
        CanalDTO canalDTO= new CanalDTO();
        canalDTO.setId(entity.getId());
        canalDTO.setType(entity.getType());
        canalDTO.setImage(entity.getImage());
        canalDTO.setVersements(new VersementMapper().toDtos(entity.getVersements()));
        return  canalDTO;
    }

    @Override
    public List<CanalDTO> toDtos(List<Canal> entities) {
        return  entities.stream().map(this::toDto).toList();
    }

    @Override
    public Canal toEntity(CanalDTO dto) {
        return null;
    }

    @Override
    public List<Canal> toEntities(List<CanalDTO> dtos) {
        return Collections.emptyList();
    }
}
