package com.sorec.dashboardcashmanagement.repository;

import com.sorec.dashboardcashmanagement.dto.VersementDTO;
import com.sorec.dashboardcashmanagement.model.Versement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VersementRepository extends JpaRepository<Versement, Long> {
    @Query("SELECT new com.sorec.dashboardcashmanagement.dto.VersementDTO(v.statut, SUM(v.montant), COUNT(DISTINCT v.pointDeVente.id)) " +
            "FROM Versement v " +
            "WHERE v.date BETWEEN :startDate AND :endDate " +
            "GROUP BY v.statut")
    List<VersementDTO> findVersementsAndPdvByStatut(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT (SUM(CASE WHEN v.statut = 'Attendu' THEN v.montant ELSE 0 END) / SUM(CASE WHEN v.statut = 'Paye'  OR v.statut ='Attendu' THEN v.montant ELSE 0 END)) * 100 " +
            "FROM Versement v " +
            "WHERE v.date BETWEEN :startDate AND :endDate")
    Double findRecoveryRate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
