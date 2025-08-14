package com.blanink.nextal.controller;

import com.blanink.nextal.entity.CustomerOrder;
import com.blanink.nextal.entity.ResultView;
import com.blanink.nextal.service.CustomerOrderService;
import com.blanink.nextal.utils.EmptyUtils;
import com.blanink.nextal.utils.PageUtils;
import com.blanink.nextal.utils.ResultUtils;
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

    @GetMapping("/list-user")
    public PageUtils getCustomerOrderPagedForUser(@RequestParam(required = false) String departmentMachine, Integer pageNo, Integer pageSize, String orderBy, String sortOrder) {
        if(EmptyUtils.isEmpty(departmentMachine))departmentMachine=null;
        Page<CustomerOrder> resultList = customerOrderService.findForUserView(pageNo, pageSize, orderBy, sortOrder, departmentMachine);
        return new PageUtils(resultList.getContent(), (int)resultList.getTotalElements());
    }

    @PutMapping("/updatePriority")
    public ResultView updatePriority(@RequestParam Integer id, @RequestParam Integer priority) {
        try {
            customerOrderService.updatePriority(id, priority);
            return ResultUtils.success("优先级更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(400,"优先级更新失败");
        }
    }
}
