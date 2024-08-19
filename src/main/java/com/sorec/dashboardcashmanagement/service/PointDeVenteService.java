package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.mapper.PointDeVenteMapper;
import com.sorec.dashboardcashmanagement.model.PointDeVente;
import com.sorec.dashboardcashmanagement.repository.PointDeVenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PointDeVenteService {

    private final PointDeVenteRepository pointDeVenteRepository;
    private final PointDeVenteMapper pointDeVenteMapper;

    public PointDeVenteService(PointDeVenteRepository pointDeVenteRepository, PointDeVenteMapper pointDeVenteMapper) {
        this.pointDeVenteRepository = pointDeVenteRepository;
        this.pointDeVenteMapper = pointDeVenteMapper;
    }

    @Transactional(readOnly = true)
    public List<PointDeVenteDTO> getAllPointDeVentes() {
        return pointDeVenteMapper.toDtos(pointDeVenteRepository.findAll());
    }

    @Transactional
    public PointDeVenteDTO createPointDeVente(PointDeVenteDTO pointDeVenteDTO) {
        return pointDeVenteMapper.toDto(pointDeVenteRepository.save(pointDeVenteMapper.toEntity(pointDeVenteDTO)));
    }

    @Transactional
    public PointDeVenteDTO updatePointDeVente(Long id, PointDeVenteDTO pointDeVenteDTO) {
        PointDeVente existingPointDeVente = pointDeVenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point de Vente not found"));

        PointDeVente updatedPointDeVente = pointDeVenteMapper.toEntity(pointDeVenteDTO);
        updatedPointDeVente.setId(existingPointDeVente.getId());

        return pointDeVenteMapper.toDto(pointDeVenteRepository.save(updatedPointDeVente));
    }

    @Transactional
    public void deletePointDeVente(Long id) {
        pointDeVenteRepository.deleteById(id);
    }
}
