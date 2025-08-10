package com.blanink.nextal.dao;

import com.blanink.nextal.entity.AluminumInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AluminumInventoryDao extends JpaRepository<AluminumInventory,Integer> {

    @Query(value ="SELECT ai FROM AluminumInventory ai WHERE " +
            "(:material IS NULL OR ai.material LIKE concat('%', :material, '%')) AND " +
            "(:productCode IS NULL OR ai.productCode LIKE concat('%', :productCode, '%')) AND " +
            "(:location IS NULL OR ai.location LIKE concat('%', :location, '%'))")
    Page<AluminumInventory> findAluminumInventoryByCriteria(@Param("material") String material, @Param("productCode") String productCode, @Param("location") String location, Pageable pageable);
}
