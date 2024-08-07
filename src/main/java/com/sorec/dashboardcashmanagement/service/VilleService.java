package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.VilleDTO;
import com.sorec.dashboardcashmanagement.mapper.VilleMapper;
import com.sorec.dashboardcashmanagement.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VilleService {
    private final VilleRepository villeRepository;
    @Autowired
    private VilleMapper villeMapper;
    @Autowired
    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public List<VilleDTO> getAllVilles() {
        return villeMapper.toDtos(villeRepository.findAll());
    }

    public List<VilleDTO> getVersementsByVille(LocalDate startDate, LocalDate endDate) {
        return villeRepository.findVersementsByVille(startDate, endDate);
    }
}
