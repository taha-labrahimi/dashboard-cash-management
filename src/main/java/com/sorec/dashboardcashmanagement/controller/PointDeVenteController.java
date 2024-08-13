package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.PointDeVenteDTO;
import com.sorec.dashboardcashmanagement.service.PointDeVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public PointDeVenteDTO createPointDeVente(@RequestBody PointDeVenteDTO pointDeVenteDTO) {
        return pointDeVenteService.createPointDeVente(pointDeVenteDTO);
    }

    @PutMapping("/{id}")
    public PointDeVenteDTO updatePointDeVente(@PathVariable Long id, @RequestBody PointDeVenteDTO pointDeVenteDTO) {
        return pointDeVenteService.updatePointDeVente(id, pointDeVenteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePointDeVente(@PathVariable Long id) {
        pointDeVenteService.deletePointDeVente(id);
    }
}
