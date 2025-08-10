package com.blanink.nextal.controller;

import com.blanink.nextal.entity.AluminumInventory;
import com.blanink.nextal.entity.CustomerOrder;
import com.blanink.nextal.service.CustomerOrderService;
import com.blanink.nextal.utils.EmptyUtils;
import com.blanink.nextal.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerOrder")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;


    @GetMapping("/list")
    public PageUtils getCustomerOrderPaged(@RequestParam(required = false) String departmentMachine, Integer pageNo, Integer pageSize, String orderBy, String sortOrder) {
        // 1. 处理空字符串为 NULL
        if(EmptyUtils.isEmpty(departmentMachine))departmentMachine=null;

        // 调用服务层方法进行查询，传入 Pageable 对象
        Page<CustomerOrder> resultList= customerOrderService.findByDepartmentMachineIsLike(pageNo,pageSize,orderBy,sortOrder,departmentMachine);
        PageUtils pageUtil = new PageUtils(resultList.getContent(), (int)resultList.getTotalElements());
        return pageUtil;
    }
}
