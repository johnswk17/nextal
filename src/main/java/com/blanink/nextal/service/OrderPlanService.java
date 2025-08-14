package com.blanink.nextal.service;

import com.blanink.nextal.dao.OrderPlanDao;
import com.blanink.nextal.entity.OrderPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderPlanService {

    @Autowired
    private OrderPlanDao orderPlanDao;

    @Transactional
    public void saveAll(List<OrderPlan> orderPlans) {
        if (orderPlans != null && !orderPlans.isEmpty()) {
            // 1. 先根据 moNo 删除旧的计划
            String moNo = orderPlans.get(0).getMoNo();
            orderPlanDao.deleteByMoNo(moNo);

            // 2. 为所有新的计划设置更新时间和更新人
            String currentUser = "admin"; // 临时的占位符
            Date currentDate = new Date();
            for (OrderPlan plan : orderPlans) {
                plan.setUpdateDate(currentDate);
                plan.setUpdateBy(currentUser);
            }

            // 3. 保存所有新的计划
            orderPlanDao.saveAll(orderPlans);
        }
    }

    public List<OrderPlan> findByMoNo(String moNo) {
        return orderPlanDao.findByMoNo(moNo);
    }
}
