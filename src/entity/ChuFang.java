package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @ClassName��ChuFang
 * @Description:ChuFangʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class ChuFang {
  private int id;//����ID
  private int chuFangId;//����ID
  private String sickName;//���˻�������
  private int doctorId;//ҽ��ID
  private String doctorName;//ҽ������
  private String sickerName;//��������
  private int drugId;//ҩƷID
  private int medicalApplianceId;//ҽ����еID
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date openTime;//������ʱ��
  private String price;//�ܼ�
  private String remark;//��ע
  private int delFlag;//ɾ�����
  private Drug drug;//ע��ҩƷ��
  private MedicalAppliance medicalAppliance;//ע��������е��
  
  
  
  
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
