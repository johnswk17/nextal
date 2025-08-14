package com.blanink.nextal.service;

import com.blanink.nextal.dao.CustomerOrderDao;
import com.blanink.nextal.dao.OrderPlanDao;
import com.blanink.nextal.entity.CustomerOrder;
import com.blanink.nextal.entity.MoldDetail;
import com.blanink.nextal.entity.OrderPlan;
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

    @Autowired
    private OrderPlanDao orderPlanDao;

    @Autowired
    private FeedbackService feedbackService;

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

        // 添加日志，检查 page 对象的信息
        System.out.println("Total elements found: " + page.getTotalElements());
        System.out.println("Current page content size: " + page.getContent().size());
        // 遍历订单并填充模具详情
        page.getContent().forEach(order -> {
            String deptMachine = order.getDepartmentMachine();
            String moldDrawingNo = order.getMoldDrawingNo();

            if (StringUtils.hasText(deptMachine) && StringUtils.hasText(moldDrawingNo) && deptMachine.contains("：")) {
                String machineName = deptMachine.substring(deptMachine.indexOf("：") + 1);
                if (StringUtils.hasText(machineName)) {
                    List<MoldDetail> moldDetails = moldDetailService.findByMachineNameAndDrawingNo(machineName, moldDrawingNo);
                    order.setMoldDetails(moldDetails);
                }
            }

            // 计算已派工数量
            Integer dispatchedQuantity = customerOrderDao.sumPlanQuantityByMoNoAndDate(order.getMoNo(), new java.util.Date());
            order.setDispatchedQuantity(dispatchedQuantity != null ? dispatchedQuantity : 0);

            // 计算今日缴库数量
            order.setTodaysFeedbackQuantity(feedbackService.getTodaysFeedbackSum(order.getMoNo()));
        });

        // 使用传统的 for 循环
//        List<CustomerOrder> orders = page.getContent();
//        for (CustomerOrder order : orders) {
//            System.out.println("Processing order ID: " + order.getId()); // 再次添加日志
//
//            String deptMachine = order.getDepartmentMachine();
//            String moldDrawingNo = order.getMoldDrawingNo();
//
//            if (StringUtils.hasText(deptMachine) && StringUtils.hasText(moldDrawingNo) && deptMachine.contains("：")) {
//                String machineName = deptMachine.substring(deptMachine.indexOf("：") + 1);
//                if (StringUtils.hasText(machineName)) {
//                    List<MoldDetail> moldDetails = moldDetailService.findByMachineNameAndDrawingNo(machineName, moldDrawingNo);
//                    order.setMoldDetails(moldDetails);
//                }
//            }
//        }

        return page;
    }

    public Page<CustomerOrder> findForUserView(Integer pageNo, Integer pageSize, String orderBy, String sortOrder, String departmentMachine) {
        Page<CustomerOrder> page = findByDepartmentMachineIsLike(pageNo, pageSize, orderBy, sortOrder, departmentMachine);

        page.getContent().forEach(order -> {
            java.util.Calendar cal = java.util.Calendar.getInstance();

            // 今天
            cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
            cal.set(java.util.Calendar.MINUTE, 0);
            cal.set(java.util.Calendar.SECOND, 0);
            cal.set(java.util.Calendar.MILLISECOND, 0);
            java.util.Date today = cal.getTime();

            // 明天
            cal.add(java.util.Calendar.DATE, 1);
            java.util.Date tomorrow = cal.getTime();

            OrderPlan todayPlan = orderPlanDao.findTopByMoNoAndPlanDate(order.getMoNo(), today);
            order.setTodayOrderPlan(todayPlan);

            OrderPlan tomorrowPlan = orderPlanDao.findTopByMoNoAndPlanDate(order.getMoNo(), tomorrow);
            order.setTomorrowOrderPlan(tomorrowPlan);
        });

        return page;
    }
}
