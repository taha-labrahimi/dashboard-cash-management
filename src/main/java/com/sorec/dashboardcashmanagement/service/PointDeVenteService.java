package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.mapper.PointDeVenteMapper;
import com.sorec.dashboardcashmanagement.repository.PointDeVenteRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PointDeVenteService {

    //Logger LOGGER = LoggerFactory.getLogger(PointDeVenteService.class);

    private final PointDeVenteRepository pointDeVenteRepository;

    private PointDeVenteMapper pointDeVenteMapper;

    @Autowired
    public PointDeVenteService(PointDeVenteRepository pointDeVenteRepository) {
        this.pointDeVenteRepository = pointDeVenteRepository;
    }

    public List<PointDeVenteDTO> getAllPointDeVentes() {
        return pointDeVenteMapper.toDtos(pointDeVenteRepository.findAll());
    }
}
