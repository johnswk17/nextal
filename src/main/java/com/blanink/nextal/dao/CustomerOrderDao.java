package com.blanink.nextal.dao;

import com.blanink.nextal.entity.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder , Integer> {

    @Query(value ="SELECT co FROM CustomerOrder co WHERE " +
            "(:departmentMachine IS NULL OR co.departmentMachine LIKE concat('%', :departmentMachine, '%'))")
    Page<CustomerOrder> findByDepartmentMachineIsLike(String departmentMachine, Pageable pageable);
}
