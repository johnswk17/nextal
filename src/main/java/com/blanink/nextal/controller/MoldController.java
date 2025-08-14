package com.blanink.nextal.controller;

import com.blanink.nextal.entity.ResultView;
import com.blanink.nextal.service.MoldService;
import com.blanink.nextal.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/mold")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MoldController {

    @Autowired
    private MoldService moldService;

    @GetMapping("/minQty")
    public ResultView getMinQty(@RequestParam String moldDrawingNo) {
        try {
            BigDecimal minQty = moldService.getMinQtyByName(moldDrawingNo);
            return ResultUtils.success(minQty);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(440,"查询最小数量失败: " + e.getMessage());
        }
    }
}
