package com.blanink.nextal.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_order_plan")
public class OrderPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_order_id")
    private Integer customerOrderId;

    @Column(name = "mo_no", length = 50)
    private String moNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "plan_date")
    private Date planDate;

    @Column(name = "plan_quantity")
    private Integer planQuantity;

    @Column(name = "mold_quantity")
    private Integer moldQuantity;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "update_by", length = 50)
    private String updateBy;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getMoNo() {
        return moNo;
    }

    public void setMoNo(String moNo) {
        this.moNo = moNo;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getPlanQuantity() {
        return planQuantity;
    }

    public void setPlanQuantity(Integer planQuantity) {
        this.planQuantity = planQuantity;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getMoldQuantity() {
        return moldQuantity;
    }

    public void setMoldQuantity(Integer moldQuantity) {
        this.moldQuantity = moldQuantity;
    }
}
