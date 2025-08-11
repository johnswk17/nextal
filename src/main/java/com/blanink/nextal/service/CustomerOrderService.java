package com.blanink.nextal.service;

import com.blanink.nextal.dao.CustomerOrderDao;
import com.blanink.nextal.entity.CustomerOrder;
import com.blanink.nextal.entity.MoldDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private MoldDetailService moldDetailService;

    @Transactional
    public void updatePriority(Integer id, Integer priority) {
        customerOrderDao.updatePriorityById(id, priority);
    }

    public Page<CustomerOrder> findByDepartmentMachineIsLike(Integer pageNo, Integer pageSize, String orderBy, String sortOrder, String departmentMachine) {
        Pageable pageable = null;
        if (orderBy == null || ("").equals(orderBy)) {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Order.asc("endDate"), Sort.Order.asc("priority")));
        } else {
            Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), orderBy);
            pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        }
        Page<CustomerOrder> page = customerOrderDao.findByDepartmentMachineIsLike(departmentMachine, pageable);

        // 遍历订单并填充模具详情
        page.getContent().forEach(order -> {
            String deptMachine = order.getDepartmentMachine();
            String moldDrawingNo = order.getMoldDrawingNo();

            if (StringUtils.hasText(deptMachine) && StringUtils.hasText(moldDrawingNo) && deptMachine.contains(":")) {
                String machineName = deptMachine.substring(deptMachine.indexOf(":") + 1);
                if (StringUtils.hasText(machineName)) {
                    List<MoldDetail> moldDetails = moldDetailService.findByMachineNameAndDrawingNo(machineName, moldDrawingNo);
                    order.setMoldDetails(moldDetails);
                }
            }
        });

        return page;
    }
}
