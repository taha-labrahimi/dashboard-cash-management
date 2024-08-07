package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.service.PointDeVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/points-de-vente")
public class PointDeVenteController {

    private final PointDeVenteService pointDeVenteService;

    @Autowired
    public PointDeVenteController(PointDeVenteService pointDeVenteService) {
        this.pointDeVenteService = pointDeVenteService;
    }

    @GetMapping
    public List<PointDeVenteDTO> getAllPointsDeVente() {
        return pointDeVenteService.getAllPointDeVentes();
    }
}
