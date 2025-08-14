package com.blanink.nextal.service;

import com.blanink.nextal.dao.MoldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MoldService {

    @Autowired
    private MoldDao moldDao;

    public BigDecimal getMinQtyByName(String name) {
        return moldDao.findMinQtyCropUtByName(name);
    }
}
