package com.blanink.nextal.controller;

import com.blanink.nextal.entity.MoldDetail;
import com.blanink.nextal.entity.ResultView;
import com.blanink.nextal.service.MoldDetailService;
import com.blanink.nextal.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moldDetail")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MoldDetailController {
    @Autowired
    private MoldDetailService moldDetailService;

    @GetMapping("/getOne")
    public ResultView getOne(@RequestParam(required = false) String machineName, String moldDrawingNumber){
        List<MoldDetail> list = moldDetailService.getOneList(machineName,moldDrawingNumber);
        return ResultUtils.success(0000,list);
    }


}
