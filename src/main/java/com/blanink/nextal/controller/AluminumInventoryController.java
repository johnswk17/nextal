package com.blanink.nextal.controller;

import com.blanink.nextal.entity.AluminumInventory;
import com.blanink.nextal.service.AluminumInventoryService;
import com.blanink.nextal.utils.EmptyUtils;
import com.blanink.nextal.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alTable")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AluminumInventoryController {
    @Autowired
    private AluminumInventoryService aluminumInventoryService;

    /**
     * GET /api/aluminum-inventory/list-ignore-case-paged
     * 示例请求：
     * 1. 查询第一页，每页10条记录：/api/aluminum-inventory/list-ignore-case-paged?page=0&size=10
     * 2. 查询第二页，每页20条记录，按 productCode 升序排序：/api/aluminum-inventory/list-ignore-case-paged?page=1&size=20&sort=productCode,asc
     * 3. 结合查询条件：/api/aluminum-inventory/list-ignore-case-paged?material=alu&page=0&size=5&sort=inboundDate,desc
     *
     * @param material    材质 (可选)
     * @param productCode 货品代号 (可选)
     * @param location    库位 (可选)
     * @param pageable    分页和排序信息（由Spring自动从请求参数解析，默认页码0，每页20条）
     * @return 包含分页信息的铝库存Page对象
     */
    @GetMapping("/listAl")
    public PageUtils getAluminumInventoriesIgnoreCasePaged(@RequestParam(required = false) String material,String productCode,  String location, Integer pageNo, Integer pageSize, String orderBy, String sortOrder) {
        // 1. 处理空字符串为 NULL
        if(EmptyUtils.isEmpty(material))material=null;
        if(EmptyUtils.isEmpty(productCode))productCode=null;
        if(EmptyUtils.isEmpty(location))location=null;

        // 调用服务层方法进行查询，传入 Pageable 对象
        Page<AluminumInventory> resultList= aluminumInventoryService.findAllAluminumInventoriesIgnoreCase(pageNo,pageSize,orderBy,sortOrder,material,productCode,location);
        PageUtils pageUtil = new PageUtils(resultList.getContent(), (int)resultList.getTotalElements());
        return pageUtil;
    }
}
