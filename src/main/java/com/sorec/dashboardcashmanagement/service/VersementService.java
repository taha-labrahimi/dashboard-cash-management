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

    private final VersementMapper versementMapper;

    @Autowired
    public VersementService(VersementRepository versementRepository , VersementMapper versementMapper) {
        this.versementRepository = versementRepository;
        this.versementMapper = versementMapper;
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

}
