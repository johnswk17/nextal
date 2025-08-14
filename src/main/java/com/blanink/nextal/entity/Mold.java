package com.blanink.nextal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MOLD") // 假设表名为 'mold'
public class Mold {

    @Id // <-- 修改点：将 @Id 注解移至此字段，并设置为表的主键
    @Column(name = "MOD_NO")
    private String modNo;

    @Column(name = "PURPOSE")
    private String purpose;

    @Column(name = "LIFT_YEAR")
    private Integer liftYear;

    @Column(name = "LIFT_TIME")
    private String liftTime;

    @Column(name = "LIFT_CROP")
    private String liftCrop;

    @Column(name = "USE_SEB")
    private String useSeb;

    @Column(name = "SPC")
    private String spc;

    @Column(name = "UT")
    private String ut;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "QTY_CROP")
    private BigDecimal qtyCrop;

    @Column(name = "QTY_DAY")
    private BigDecimal qtyDay;

    @Column(name = "QTY_LEN")
    private BigDecimal qtyLen;

    @Column(name = "QTY_CIR_IN")
    private BigDecimal qtyCirIn;

    @Column(name = "QTY_CIR_OUT")
    private BigDecimal qtyCirOut;

    @Column(name = "QTY_CROP_UT")
    private String qtyCropUt;

    @Column(name = "SHOW_ID")
    private String showId;

    @Column(name = "REM")
    private String rem; // 备注

    @Column(name = "PIC")
    private String pic; // 图片路径或Base64字符串

    @Column(name = "NAME")
    private String name;

    @Column(name = "TAX_RTO")
    private BigDecimal taxRto; // 税率

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "HEIGHT")
    private BigDecimal height;

    @Column(name = "WIDTH")
    private BigDecimal width;

    @Column(name = "SPC_ID")
    private String spcId;

    @Column(name = "UT_TIME")
    private String utTime;

    @Column(name = "TIME_UNIT")
    private String timeUnit;

    @Column(name = "LINES")
    private Integer lines;

    @Column(name = "FT_TYPE")
    private String ftType;

    @Column(name = "FT_MM")
    private BigDecimal ftMm;

    @Column(name = "USR")
    private String usr;

    @Column(name = "SYS_DATE")
    private Date sysDate;

    @Column(name = "DEP")
    private String dep;

    @Column(name = "DEPRO_NO")
    private String deproNo;

    @Column(name = "MODIFY_DD")
    private Date modifyDd;

    @Column(name = "MODIFY_MAN")
    private String modifyMan;

    @Column(name = "APP_NAME_DATA")
    private String appNameData;

    public String getModNo() {
        return modNo;
    }

    public void setModNo(String modNo) {
        this.modNo = modNo;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getLiftYear() {
        return liftYear;
    }

    public void setLiftYear(Integer liftYear) {
        this.liftYear = liftYear;
    }

    public String getLiftTime() {
        return liftTime;
    }

    public void setLiftTime(String liftTime) {
        this.liftTime = liftTime;
    }

    public String getLiftCrop() {
        return liftCrop;
    }

    public void setLiftCrop(String liftCrop) {
        this.liftCrop = liftCrop;
    }

    public String getUseSeb() {
        return useSeb;
    }

    public void setUseSeb(String useSeb) {
        this.useSeb = useSeb;
    }

    public String getSpc() {
        return spc;
    }

    public void setSpc(String spc) {
        this.spc = spc;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getQtyCrop() {
        return qtyCrop;
    }

    public void setQtyCrop(BigDecimal qtyCrop) {
        this.qtyCrop = qtyCrop;
    }

    public BigDecimal getQtyDay() {
        return qtyDay;
    }

    public void setQtyDay(BigDecimal qtyDay) {
        this.qtyDay = qtyDay;
    }

    public BigDecimal getQtyLen() {
        return qtyLen;
    }

    public void setQtyLen(BigDecimal qtyLen) {
        this.qtyLen = qtyLen;
    }

    public BigDecimal getQtyCirIn() {
        return qtyCirIn;
    }

    public void setQtyCirIn(BigDecimal qtyCirIn) {
        this.qtyCirIn = qtyCirIn;
    }

    public BigDecimal getQtyCirOut() {
        return qtyCirOut;
    }

    public void setQtyCirOut(BigDecimal qtyCirOut) {
        this.qtyCirOut = qtyCirOut;
    }

    public String getQtyCropUt() {
        return qtyCropUt;
    }

    public void setQtyCropUt(String qtyCropUt) {
        this.qtyCropUt = qtyCropUt;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTaxRto() {
        return taxRto;
    }

    public void setTaxRto(BigDecimal taxRto) {
        this.taxRto = taxRto;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getUtTime() {
        return utTime;
    }

    public void setUtTime(String utTime) {
        this.utTime = utTime;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    public String getFtType() {
        return ftType;
    }

    public void setFtType(String ftType) {
        this.ftType = ftType;
    }

    public BigDecimal getFtMm() {
        return ftMm;
    }

    public void setFtMm(BigDecimal ftMm) {
        this.ftMm = ftMm;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDeproNo() {
        return deproNo;
    }

    public void setDeproNo(String deproNo) {
        this.deproNo = deproNo;
    }

    public Date getModifyDd() {
        return modifyDd;
    }

    public void setModifyDd(Date modifyDd) {
        this.modifyDd = modifyDd;
    }

    public String getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(String modifyMan) {
        this.modifyMan = modifyMan;
    }

    public String getAppNameData() {
        return appNameData;
    }

    public void setAppNameData(String appNameData) {
        this.appNameData = appNameData;
    }
}