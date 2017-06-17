package entity;

import java.util.Date;

/**
 * @ClassName：Drug
 * @Description:Drug实体类
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Drug {
  private int id;//主键
  private int drugId;//药品ID
  private String drugName;//药品学名
  private String drugCompany;//出厂公司
  private String drugPrice;//价格
  private String drugAmount;//库存
  private Date drugExp;//出厂日期
  private String drugRemark;//备注
  private int delFlag;//删除标记
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
   * @return the drugName
   */
  public String getDrugName() {
    return drugName;
  }
  /**
   * @param drugName the drugName to set
   */
  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }
  /**
   * @return the drugCompany
   */
  public String getDrugCompany() {
    return drugCompany;
  }
  /**
   * @param drugCompany the drugCompany to set
   */
  public void setDrugCompany(String drugCompany) {
    this.drugCompany = drugCompany;
  }
  /**
   * @return the drugPrice
   */
  public String getDrugPrice() {
    return drugPrice;
  }
  /**
   * @param drugPrice the drugPrice to set
   */
  public void setDrugPrice(String drugPrice) {
    this.drugPrice = drugPrice;
  }
  /**
   * @return the drugAmount
   */
  public String getDrugAmount() {
    return drugAmount;
  }
  /**
   * @param drugAmount the drugAmount to set
   */
  public void setDrugAmount(String drugAmount) {
    this.drugAmount = drugAmount;
  }
  /**
   * @return the drugExp
   */
  public Date getDrugExp() {
    return drugExp;
  }
  /**
   * @param drugExp the drugExp to set
   */
  public void setDrugExp(Date drugExp) {
    this.drugExp = drugExp;
  }
  /**
   * @return the drugRemark
   */
  public String getDrugRemark() {
    return drugRemark;
  }
  /**
   * @param drugRemark the drugRemark to set
   */
  public void setDrugRemark(String drugRemark) {
    this.drugRemark = drugRemark;
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
