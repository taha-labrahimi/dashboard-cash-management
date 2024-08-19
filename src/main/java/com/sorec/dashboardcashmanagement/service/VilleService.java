package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.VilleDTO;
import com.sorec.dashboardcashmanagement.mapper.VilleMapper;
import com.sorec.dashboardcashmanagement.model.Ville;
import com.sorec.dashboardcashmanagement.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class VilleService {

    private final VilleRepository villeRepository;

    private final VilleMapper villeMapper;

    @Autowired
    public VilleService(VilleRepository villeRepository, VilleMapper villeMapper) {
        this.villeRepository = villeRepository;
        this.villeMapper = villeMapper;
    }

    @Transactional(readOnly = true)
    public List<VilleDTO> getAllVilles() {
        return villeMapper.toDtos(villeRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<VilleDTO> getVersementsByVille(LocalDate startDate, LocalDate endDate) {
        return villeRepository.findVersementsByVille(startDate, endDate);
    }

    @Transactional
    public VilleDTO createVille(VilleDTO villeDTO) {
        return villeMapper.toDto(villeRepository.save(villeMapper.toEntity(villeDTO)));
    }

    @Transactional
    public VilleDTO updateVille(Long id, VilleDTO villeDTO) {
        Ville existingVille = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found"));

        Ville updatedVille = villeMapper.toEntity(villeDTO);
        updatedVille.setId(existingVille.getId());

        return villeMapper.toDto(villeRepository.save(updatedVille));
    }


    @Transactional
    public void deleteVille(Long id) {
        villeRepository.deleteById(id);
    }
}
