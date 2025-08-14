package com.blanink.nextal.service;

import com.blanink.nextal.dao.FeedbackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    public BigDecimal getTodaysFeedbackSum(String moNo) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date today = cal.getTime();

        BigDecimal sum = feedbackDao.sumSubQuantityByMoNoAndDate(moNo, today);
        return sum != null ? sum : BigDecimal.ZERO;
    }
}
