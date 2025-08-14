package com.blanink.nextal.dao;

import com.blanink.nextal.entity.Mold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MoldDao extends JpaRepository<Mold, String> {

    @Query("SELECT min(m.qtyCropUt) FROM Mold m WHERE m.name = :name")
    BigDecimal findMinQtyCropUtByName(@Param("name") String name);
}