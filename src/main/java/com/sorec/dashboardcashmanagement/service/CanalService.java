package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.CanalDTO;
import com.sorec.dashboardcashmanagement.mapper.CanalMapper;
import com.sorec.dashboardcashmanagement.repository.CanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CanalService {

    private final CanalRepository canalRepository;
    @Autowired
    private CanalMapper canalMapper;


    @Autowired
    public CanalService(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }

    @Transactional(readOnly = true)
    public List<CanalDTO> getAllCanals() {
        return canalMapper.toDtos(canalRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<CanalDTO> getNombreDePdvParCanal(LocalDate startDate, LocalDate endDate) {
        return  canalRepository.findNombreDePdvParCanal(startDate, endDate);
    }

    public Double getTotalVersementsByDateRange(LocalDate startDate, LocalDate endDate) {
        return canalRepository.findTotalVersementsByDateRange(startDate, endDate);
    }

    public List<CanalDTO> getVersementsAttendusParCanal(LocalDate startDate, LocalDate endDate) {
        return canalRepository.findVersementsAttendusParCanal(startDate, endDate);
    }
}
