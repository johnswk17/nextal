package com.blanink.nextal.service;

import com.blanink.nextal.dao.AluminumInventoryDao;
import com.blanink.nextal.entity.AluminumInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AluminumInventoryService {
    @Autowired
    private AluminumInventoryDao aluminumInventoryDao;

    /**
     * 根据材质、货品代号和库位获取铝库存列表（忽略大小写），并支持分页。
     *
     * @param material    材质
     * @param productCode 货品代号
     * @param location    库位
     * @param pageable    分页信息 (由控制器传入)
     * @return 包含分页信息的库存Page对象
     */
    public Page<AluminumInventory> findAllAluminumInventoriesIgnoreCase(Integer pageNo, Integer pageSize, String orderBy,String sortOrder,String material, String productCode, String location) {
        // 调用 Spring Data JPA 自动生成的方法，传入 Pageable
// 创建一个排序对象
        Pageable pageable=null;
        if(orderBy==null||("").equals(orderBy)){
            pageable =  PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC,"id");
        }else{
            Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), orderBy);
            pageable =  PageRequest.of(pageNo-1, pageSize, sort);
        }
        return aluminumInventoryDao.findAluminumInventoryByCriteria(material, productCode, location, pageable);
    }

}
