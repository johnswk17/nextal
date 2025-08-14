package com.blanink.nextal.dao;

import com.blanink.nextal.entity.OrderPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPlanDao extends JpaRepository<OrderPlan, Integer> {

    List<OrderPlan> findByMoNo(String moNo);

    @Modifying
    @Query("DELETE FROM OrderPlan p WHERE p.moNo = :moNo")
    void deleteByMoNo(@Param("moNo") String moNo);

    OrderPlan findTopByMoNoAndPlanDate(String moNo, java.util.Date planDate);
}