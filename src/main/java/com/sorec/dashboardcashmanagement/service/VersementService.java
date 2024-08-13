package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.VersementDTO;
import com.sorec.dashboardcashmanagement.mapper.VersementMapper;
import com.sorec.dashboardcashmanagement.repository.VersementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class VersementService {

    private final VersementRepository versementRepository;
    @Autowired
    private VersementMapper versementMapper;

    @Autowired
    public VersementService(VersementRepository versementRepository) {
        this.versementRepository = versementRepository;
    }

    @Transactional(readOnly = true)
    public List<VersementDTO> getAllVersements() {
        return versementMapper.toDtos(versementRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<VersementDTO> getVersementsAndPdvByStatut(LocalDate startDate, LocalDate endDate) {
        return versementRepository.findVersementsAndPdvByStatut(startDate, endDate);
    }

    @Transactional(readOnly = true)
    public Double getRecoveryRate(LocalDate startDate, LocalDate endDate) {
        return versementRepository.findRecoveryRate(startDate, endDate);
    }

    @Transactional
    public VersementDTO createVersement(VersementDTO versementDTO) {
        return versementMapper.toDto(versementRepository.save(versementMapper.toEntity(versementDTO)));
    }



    @Transactional
    public void deleteVersement(Long id) {
        versementRepository.deleteById(id);
    }
}
