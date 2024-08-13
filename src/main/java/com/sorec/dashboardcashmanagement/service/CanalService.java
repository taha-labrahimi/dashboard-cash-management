package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.CanalDTO;
import com.sorec.dashboardcashmanagement.mapper.CanalMapper;
import com.sorec.dashboardcashmanagement.model.Canal;
import com.sorec.dashboardcashmanagement.repository.CanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CanalService {

    private final CanalRepository canalRepository;
    private final CanalMapper canalMapper;

    @Autowired
    public CanalService(CanalRepository canalRepository, CanalMapper canalMapper) {
        this.canalRepository = canalRepository;
        this.canalMapper = canalMapper;
    }

    @Transactional(readOnly = true)
    public List<CanalDTO> getAllCanals() {
        return canalMapper.toDtos(canalRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<CanalDTO> getNombreDePdvParCanal(LocalDate startDate, LocalDate endDate) {
        return canalRepository.findNombreDePdvParCanal(startDate, endDate);
    }

    @Transactional(readOnly = true)
    public Double getTotalVersementsByDateRange(LocalDate startDate, LocalDate endDate) {
        return canalRepository.findTotalVersementsByDateRange(startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<CanalDTO> getVersementsAttendusParCanal(LocalDate startDate, LocalDate endDate) {
        return canalRepository.findVersementsAttendusParCanal(startDate, endDate);
    }

    @Transactional
    public CanalDTO createCanal(CanalDTO canalDTO) {
        return canalMapper.toDto(canalRepository.save(canalMapper.toEntity(canalDTO)));
    }

    @Transactional
    public CanalDTO updateCanal(Long id, CanalDTO canalDTO) {
        Canal existingCanal = canalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Canal not found"));

        Canal updatedCanal = canalMapper.toEntity(canalDTO);
        updatedCanal.setId(existingCanal.getId());

        return canalMapper.toDto(canalRepository.save(updatedCanal));
    }

    @Transactional
    public void deleteCanal(Long id) {
        canalRepository.deleteById(id);
    }
}
