package com.blanink.nextal.dao;

import com.blanink.nextal.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, String> {

    @Query("SELECT SUM(f.subQuantity) FROM Feedback f WHERE f.manufacturingOrderNo = :moNo AND f.warehouseEntryDate = :date")
    BigDecimal sumSubQuantityByMoNoAndDate(@Param("moNo") String moNo, @Param("date") Date date);
}
