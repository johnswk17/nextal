package com.blanink.nextal.dao;

import com.blanink.nextal.entity.MoldDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoldDetailDao extends JpaRepository<MoldDetail,Integer> {
    List<MoldDetail> findByMachineNameLikeAndMoldCodeLike(String machineName, String moldCode);

    List<MoldDetail> findByMachineNameIsAndMoldCodeIs(String machineName, String moldCode);
    @Query(value ="SELECT md FROM MoldDetail md WHERE " +
            "(:machineName IS NULL OR md.machineName LIKE concat('%', :machineName, '%')) AND" +
            "(:moldDrawingNumber IS NULL OR md.moldDrawingNumber = :moldDrawingNumber )")
    List<MoldDetail> findByMachineNameLikeAndMoldDrawingNumberIs(String machineName,String moldDrawingNumber);
}
