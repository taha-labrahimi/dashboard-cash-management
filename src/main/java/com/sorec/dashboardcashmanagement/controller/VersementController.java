package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.VersementDTO;
import com.sorec.dashboardcashmanagement.service.VersementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/versements")
public class VersementController {

    private final VersementService versementService;

    @Autowired
    public VersementController(VersementService versementService) {
        this.versementService = versementService;
    }

    @GetMapping
    public List<VersementDTO> getAllVersements() {
        return versementService.getAllVersements();
    }



    @GetMapping("/statut/{startDate}/{endDate}")
    public List<VersementDTO> getVersementsAndPdvByStatut(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return versementService.getVersementsAndPdvByStatut(startDate, endDate);
    }

    @GetMapping("/recovery-rate/{startDate}/{endDate}")
    public Double getRecoveryRate(
            @PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate
    ) {
        return versementService.getRecoveryRate(startDate, endDate);
    }
}
