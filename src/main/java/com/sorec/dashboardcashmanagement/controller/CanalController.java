package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.CanalDTO;
import com.sorec.dashboardcashmanagement.service.CanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/canals")
public class CanalController {

    private final CanalService canalService;

    @Autowired
    public CanalController(CanalService canalService) {
        this.canalService = canalService;
    }

    @GetMapping
    public List<CanalDTO> getAllCanals() {
        return canalService.getAllCanals();
    }

    @PostMapping
    public CanalDTO createCanal(@RequestBody CanalDTO canalDTO) {
        return canalService.createCanal(canalDTO);
    }

    @PutMapping("/{id}")
    public CanalDTO updateCanal(@PathVariable Long id, @RequestBody CanalDTO canalDTO) {
        return canalService.updateCanal(id, canalDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCanal(@PathVariable Long id) {
        canalService.deleteCanal(id);
    }

    @GetMapping("/nombre-de-pdv/{startDate}/{endDate}")
    public List<CanalDTO> getNombreDePdvParCanal(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return canalService.getNombreDePdvParCanal(startDate, endDate);
    }

    @GetMapping("/total-versements/{startDate}/{endDate}")
    public Double getTotalVersementsByDateRange(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return canalService.getTotalVersementsByDateRange(startDate, endDate);
    }

    @GetMapping("/versements-attendus/{startDate}/{endDate}")
    public List<CanalDTO> getVersementsAttendusParCanal(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return canalService.getVersementsAttendusParCanal(startDate, endDate);
    }
}
