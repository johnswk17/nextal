package com.blanink.nextal.service;

import com.blanink.nextal.dao.MoldDetailDao;
import com.blanink.nextal.entity.MoldDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoldDetailService {

    @Autowired
    private MoldDetailDao moldDetailDao;

    public MoldDetail getOneMold(String machineName, String moldCode){
        List<MoldDetail> moldDetailList= moldDetailDao.findByMachineNameIsAndMoldCodeIs(machineName,moldCode);
        return moldDetailList.get(0);
    }

    public List<MoldDetail> getOneList(String machineName,String moldDrawingNumber){
        List<MoldDetail> moldDetailList= moldDetailDao.findByMachineNameLikeAndMoldDrawingNumberIs(machineName,moldDrawingNumber);
        return moldDetailList;
    }

    public List<MoldDetail> findByMachineNameAndDrawingNo(String machineName, String moldDrawingNo) {
        return moldDetailDao.findByMachineNameContainingAndMoldDrawingNumber(machineName, moldDrawingNo);
    }
}
