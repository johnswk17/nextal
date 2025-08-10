package com.blanink.nextal.service;

import com.blanink.nextal.dao.CustomerOrderDao;
import com.blanink.nextal.entity.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    public Page<CustomerOrder> findByDepartmentMachineIsLike(Integer pageNo, Integer pageSize, String orderBy,String sortOrder,String departmentMachine){
        Pageable pageable=null;
        if(orderBy==null||("").equals(orderBy)){
            pageable =  PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC,"id");
        }else{
            Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), orderBy);
            pageable =  PageRequest.of(pageNo-1, pageSize, sort);
        }
        return customerOrderDao.findByDepartmentMachineIsLike(departmentMachine,pageable);
    }
}
