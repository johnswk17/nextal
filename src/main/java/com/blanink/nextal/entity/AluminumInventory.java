package com.blanink.nextal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_aluminum_inventory")
@Data // Lombok 注解，自动生成 getter, setter, toString, equals, hashCode
public class AluminumInventory {
    /**
     * 唯一标识符，主键ID
     * 对应数据库表中的 `id` 字段，且为自增类型。
     */
    @Id // 标记该字段是表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略：数据库自增（对应 SQL Server 的 IDENTITY(1,1)）
    @Column(name = "id") // 指定Java字段 `id` 对应数据库列 `id`
    private Integer id;

    /**
     * 货品代号
     * 对应数据库表中的 `product_code` 字段。
     */
    @Column(name = "product_code", length = 50) // 指定数据库列名和最大长度
    private String productCode; // 转换为驼峰命名法

    /**
     * 货品名称
     * 对应数据库表中的 `product_name` 字段。
     */
    @Column(name = "product_name", length = 100)
    private String productName;

    /**
     * 材质
     * 对应数据库表中的 `material` 字段。
     */
    @Column(name = "material", length = 50)
    private String material;

    /**
     * 批号
     * 对应数据库表中的 `batch_no` 字段。
     */
    @Column(name = "batch_no", length = 50)
    private String batchNo;

    /**
     * 库位
     * 对应数据库表中的 `location` 字段。
     */
    @Column(name = "location", length = 50)
    private String location;

    /**
     * 主数量
     * 对应数据库表中的 `main_quantity` 字段，使用 BigDecimal 以保证小数精度。
     */
    @Column(name = "main_quantity", precision = 18, scale = 4) // precision: 总位数, scale: 小数位数
    private BigDecimal mainQuantity;

    /**
     * 副数量
     * 对应数据库表中的 `secondary_quantity` 字段，使用 BigDecimal 以保证小数精度。
     */
    @Column(name = "secondary_quantity", precision = 18, scale = 4)
    private BigDecimal secondaryQuantity;

    /**
     * 进货日期
     * 对应数据库表中的 `inbound_date` 字段。
     */
    @Column(name = "inbound_date")
    private LocalDateTime inboundDate; // 使用 LocalDateTime 映射数据库的 DATETIME 类型

    /**
     * 更新时间
     * 对应数据库表中的 `update_time` 字段。
     * 该字段在数据库中通常由触发器或默认值自动填充，在应用层一般不需要手动设置，
     * 但在实体类中定义是为了能够读取和展示这个值。
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getMainQuantity() {
        return mainQuantity;
    }

    public void setMainQuantity(BigDecimal mainQuantity) {
        this.mainQuantity = mainQuantity;
    }

    public BigDecimal getSecondaryQuantity() {
        return secondaryQuantity;
    }

    public void setSecondaryQuantity(BigDecimal secondaryQuantity) {
        this.secondaryQuantity = secondaryQuantity;
    }

    public LocalDateTime getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(LocalDateTime inboundDate) {
        this.inboundDate = inboundDate;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
