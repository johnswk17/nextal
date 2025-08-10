package com.blanink.nextal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * 模具详情实体类 (Mold Detail Entity)
 * 该类映射到数据库中的 'tbl_mold_detail' 表。
 */
@Entity
@Table(name = "tbl_mold_detail")
@Data // Lombok 注解，自动生成 getter, setter, toString, equals, hashCode
public class MoldDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mold_code", nullable = false, unique = true, length = 50)
    private String moldCode;  //磨具编码

    @Column(name = "location_name", length = 100)
    private String locationName; //库位名称

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;//调拨日

    @Column(name = "machine_name", length = 100)
    private String machineName; //机台名称

    @Column(name = "mold_drawing_number", length = 100)
    private String moldDrawingNumber; //磨具图号

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate; //更新时间

    // JPA 要求有一个无参的构造函数
    public MoldDetail() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoldCode() {
        return moldCode;
    }

    public void setMoldCode(String moldCode) {
        this.moldCode = moldCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMoldDrawingNumber() {
        return moldDrawingNumber;
    }

    public void setMoldDrawingNumber(String moldDrawingNumber) {
        this.moldDrawingNumber = moldDrawingNumber;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "MoldDetail{" +
                "id=" + id +
                ", moldCode='" + moldCode + '\'' +
                ", locationName='" + locationName + '\'' +
                ", transferDate=" + transferDate +
                ", machineName='" + machineName + '\'' +
                ", moldDrawingNumber='" + moldDrawingNumber + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoldDetail that = (MoldDetail) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
