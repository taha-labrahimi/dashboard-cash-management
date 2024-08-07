package com.sorec.dashboardcashmanagement.repository;

import com.sorec.dashboardcashmanagement.dto.VilleDTO;
import com.sorec.dashboardcashmanagement.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Query("SELECT new com.sorec.dashboardcashmanagement.dto.VilleDTO(ville.nom, SUM(v.montant)) " +
            "FROM Versement v " +
            "JOIN v.pointDeVente pdv " +
            "JOIN pdv.ville ville " +
            "WHERE v.date BETWEEN :startDate AND :endDate " +
            "GROUP BY ville.nom")
    List<VilleDTO> findVersementsByVille(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
