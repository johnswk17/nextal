package com.blanink.nextal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TF_MM0") // 对应 SQL 中的表名
public class Feedback {
    @Id
    @Column(name = "MM_NO")
    private String warehouseEntryNo;

    @Column(name = "MM_DD")
    private Date warehouseEntryDate;


    @Column(name = "MO_NO")
    private String manufacturingOrderNo;

    @Column(name = "PRD_NO")
    private String productCode;

    @Column(name = "QTY")
    private BigDecimal mainQuantity;

    @Column(name = "QTY1")
    private BigDecimal subQuantity;

    // Constructors, Getters and Setters
    public Feedback() {
    }

    public Date getWarehouseEntryDate() {
        return warehouseEntryDate;
    }

    public void setWarehouseEntryDate(Date warehouseEntryDate) {
        this.warehouseEntryDate = warehouseEntryDate;
    }

    public String getWarehouseEntryNo() {
        return warehouseEntryNo;
    }

    public void setWarehouseEntryNo(String warehouseEntryNo) {
        this.warehouseEntryNo = warehouseEntryNo;
    }

    public String getManufacturingOrderNo() {
        return manufacturingOrderNo;
    }

    public void setManufacturingOrderNo(String manufacturingOrderNo) {
        this.manufacturingOrderNo = manufacturingOrderNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getMainQuantity() {
        return mainQuantity;
    }

    public void setMainQuantity(BigDecimal mainQuantity) {
        this.mainQuantity = mainQuantity;
    }

    public BigDecimal getSubQuantity() {
        return subQuantity;
    }

    public void setSubQuantity(BigDecimal subQuantity) {
        this.subQuantity = subQuantity;
    }
}
