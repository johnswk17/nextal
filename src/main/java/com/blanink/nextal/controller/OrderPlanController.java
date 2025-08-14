package com.blanink.nextal.controller;

import com.blanink.nextal.entity.OrderPlan;
import com.blanink.nextal.entity.ResultView;
import com.blanink.nextal.service.OrderPlanService;
import com.blanink.nextal.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderPlan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderPlanController {

    @Autowired
    private OrderPlanService orderPlanService;

    @GetMapping("/list")
    public ResultView getOrderPlans(@RequestParam String moNo) {
        try {
            List<OrderPlan> plans = orderPlanService.findByMoNo(moNo);
            return ResultUtils.success(plans);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(440,"查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/batchCreate")
    public ResultView batchCreate(@RequestBody List<OrderPlan> orderPlans) {
        try {
            orderPlanService.saveAll(orderPlans);
            return ResultUtils.success("派工计划保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(440,"派工计划保存失败: " + e.getMessage());
        }
    }
}
