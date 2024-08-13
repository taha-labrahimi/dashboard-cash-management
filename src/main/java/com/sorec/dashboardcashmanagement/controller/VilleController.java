package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.VilleDTO;
import com.sorec.dashboardcashmanagement.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/villes")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public List<VilleDTO> getAllVilles() {
        return villeService.getAllVilles();
    }

    @PostMapping
    public VilleDTO createVille(@RequestBody VilleDTO villeDTO) {
        return villeService.createVille(villeDTO);
    }

    @PutMapping("/{id}")
    public VilleDTO updateVille(@PathVariable Long id, @RequestBody VilleDTO villeDTO) {
        return villeService.updateVille(id, villeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Long id) {
        villeService.deleteVille(id);
    }

    @GetMapping("/versements/{startDate}/{endDate}")
    public List<VilleDTO> getVersementsByVille(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        return villeService.getVersementsByVille(startDate, endDate);
    }
}
