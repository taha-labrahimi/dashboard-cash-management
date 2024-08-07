package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.VersementDTO;
import com.sorec.dashboardcashmanagement.mapper.VersementMapper;
import com.sorec.dashboardcashmanagement.repository.VersementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<VersementDTO> getAllVersements() {
        return versementMapper.toDtos(versementRepository.findAll());
    }

    public List<VersementDTO> getVersementsAndPdvByStatut(LocalDate startDate, LocalDate endDate) {
        return versementRepository.findVersementsAndPdvByStatut(startDate, endDate);
    }

    public Double getRecoveryRate(LocalDate startDate, LocalDate endDate) {
        return versementRepository.findRecoveryRate(startDate, endDate);
    }
}
