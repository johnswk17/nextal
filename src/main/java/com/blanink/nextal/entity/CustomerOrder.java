package com.blanink.nextal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_customer_order")

public class CustomerOrder {
    /**
     * 唯一标识符，主键ID
     * 对应数据库表中的 `id` 字段，且为自增类型。
     */
    @Id // 标记该字段是表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略：数据库自增（对应 SQL Server 的 IDENTITY(1,1)）
    @Column(name = "id") // 指定Java字段 `id` 对应数据库列 `id`
    private Integer id;

    /**
     * 客户代号
     */
    @Column(name = "customer_no", length = 50)
    private String customerNo;

    /**
     * 制令单号 (主键)
     */
    @Column(name = "mo_no", length = 50)
    private String moNo;

    /**
     * 部门机台 (新增字段)
     */
    @Column(name = "department_machine", length = 255)
    private String departmentMachine;

    /**
     * 模具图号 (新增字段)
     */
    @Column(name = "mold_drawing_no", length = 255)
    private String moldDrawingNo;

    /**
     * 货品代号
     */
    @Column(name = "mrp_no", length = 50)
    private String mrpNo;

    /**
     * 规格
     */
    @Column(name = "spec", length = 255)
    private String spec;

    /**
     * 材质
     */
    @Column(name = "material", length = 255)
    private String material;

    /**
     * 订单量 (类型已修改为 BigDecimal)
     */
    @Column(name = "order_qty", precision = 18, scale = 4)
    private String orderQty;

    /**
     * 已完工量 (类型已修改为 BigDecimal)
     */
    @Column(name = "finished_qty", precision = 18, scale = 4)
    private String finishedQty;

    /**
     * 未完工量 (类型已修改为 BigDecimal)
     */
    @Column(name = "unfinished_qty", precision = 18, scale = 4)
    private String unfinishedQty;

    /**
     * 预开工日
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 预完工日
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 备注
     */
    @Column(name = "remark", length = 255)
    private String remark;

    /**
     * 最后更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 优先级
     */
    @Column(name = "priority")
    private Integer priority;

    @Transient
    private List<MoldDetail> moldDetails;

    public List<MoldDetail> getMoldDetails() {
        return moldDetails;
    }

    public void setMoldDetails(List<MoldDetail> moldDetails) {
        this.moldDetails = moldDetails;
    }

    // --- Getters and Setters ---

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getMoNo() {
        return moNo;
    }

    public void setMoNo(String moNo) {
        this.moNo = moNo;
    }

    public String getDepartmentMachine() {
        return departmentMachine;
    }

    public void setDepartmentMachine(String departmentMachine) {
        this.departmentMachine = departmentMachine;
    }

    public String getMrpNo() {
        return mrpNo;
    }

    public void setMrpNo(String mrpNo) {
        this.mrpNo = mrpNo;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    public String getFinishedQty() {
        return finishedQty;
    }

    public void setFinishedQty(String finishedQty) {
        this.finishedQty = finishedQty;
    }

    public String getUnfinishedQty() {
        return unfinishedQty;
    }

    public void setUnfinishedQty(String unfinishedQty) {
        this.unfinishedQty = unfinishedQty;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoldDrawingNo() {
        return moldDrawingNo;
    }

    public void setMoldDrawingNo(String moldDrawingNo) {
        this.moldDrawingNo = moldDrawingNo;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
