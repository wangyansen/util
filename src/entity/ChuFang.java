package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @ClassName：ChuFang
 * @Description:ChuFang实体类
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class ChuFang {
  private int id;//主键ID
  private int chuFangId;//处方ID
  private String sickName;//病人患病名称
  private int doctorId;//医生ID
  private String doctorName;//医生姓名
  private String sickerName;//病人姓名
  private int drugId;//药品ID
  private int medicalApplianceId;//医疗器械ID
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date openTime;//开处方时间
  private String price;//总价
  private String remark;//备注
  private int delFlag;//删除标记
  private Drug drug;//注入药品类
  private MedicalAppliance medicalAppliance;//注入理疗器械类
  
  
  
  
  public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
public Drug getDrug() {
	return drug;
}
public void setDrug(Drug drug) {
	this.drug = drug;
}
public MedicalAppliance getMedicalAppliance() {
	return medicalAppliance;
}
public void setMedicalAppliance(MedicalAppliance medicalAppliance) {
	this.medicalAppliance = medicalAppliance;
}
/**
   * @return the id
   */
  public int getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }
  /**
   * @return the chuFangId
   */
  public int getChuFangId() {
    return chuFangId;
  }
  /**
   * @param chuFangId the chuFangId to set
   */
  public void setChuFangId(int chuFangId) {
    this.chuFangId = chuFangId;
  }
  /**
   * @return the sickName
   */
  public String getSickName() {
    return sickName;
  }
  /**
   * @param sickName the sickName to set
   */
  public void setSickName(String sickName) {
    this.sickName = sickName;
  }
  
  public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getSickerName() {
	return sickerName;
}
public void setSickerName(String sickerName) {
	this.sickerName = sickerName;
}
/**
   * @return the drugId
   */
  public int getDrugId() {
    return drugId;
  }
  /**
   * @param drugId the drugId to set
   */
  public void setDrugId(int drugId) {
    this.drugId = drugId;
  }
  /**
   * @return the medicalApplianceId
   */
  public int getMedicalApplianceId() {
    return medicalApplianceId;
  }
  /**
   * @param medicalApplianceId the medicalApplianceId to set
   */
  public void setMedicalApplianceId(int medicalApplianceId) {
    this.medicalApplianceId = medicalApplianceId;
  }
  /**
   * @return the openTime
   */
  public Date getOpenTime() {
    return openTime;
  }
  /**
   * @param openTime the openTime to set
   */
  public void setOpenTime(Date openTime) {
    this.openTime = openTime;
  }
  /**
   * @return the price
   */
  public String getPrice() {
    return price;
  }
  /**
   * @param price the price to set
   */
  public void setPrice(String price) {
    this.price = price;
  }
  /**
   * @return the remark
   */
  public String getRemark() {
    return remark;
  }
  /**
   * @param remark the remark to set
   */
  public void setRemark(String remark) {
    this.remark = remark;
  }
  /**
   * @return the delFlag
   */
  public int getDelFlag() {
    return delFlag;
  }
  /**
   * @param delFlag the delFlag to set
   */
  public void setDelFlag(int delFlag) {
    this.delFlag = delFlag;
  }
  
  
  
  
}
