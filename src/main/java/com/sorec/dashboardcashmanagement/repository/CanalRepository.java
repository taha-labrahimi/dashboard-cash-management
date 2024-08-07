package com.sorec.dashboardcashmanagement.repository;

import com.sorec.dashboardcashmanagement.dto.CanalDTO;
import com.sorec.dashboardcashmanagement.model.Canal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CanalRepository extends JpaRepository<Canal, Long> {

    @Query("SELECT new com.sorec.dashboardcashmanagement.dto.CanalDTO(v.canal.type, COUNT(DISTINCT v.pointDeVente.id)) FROM Versement  v WHERE v.date BETWEEN :startDate AND :endDate GROUP BY v.canal.type")
    List<CanalDTO> findNombreDePdvParCanal(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT SUM(v.montant) FROM Versement v WHERE v.date BETWEEN :startDate AND :endDate AND (v.statut = 'Paye' OR v.statut = 'Attendu')")
    Double findTotalVersementsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT new com.sorec.dashboardcashmanagement.dto.CanalDTO(v.canal.type, SUM(v.montant), COUNT(DISTINCT v.pointDeVente.id),v.canal.image) FROM Versement v WHERE v.date BETWEEN :startDate AND :endDate AND  v.statut = 'Attendu' GROUP BY v.canal.type,v.canal.image")
    List<CanalDTO> findVersementsAttendusParCanal(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
