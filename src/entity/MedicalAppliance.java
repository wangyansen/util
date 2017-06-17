package entity;

import java.util.Date;

/**
 * @ClassName��MedicalAppliance
 * @Description:MedicalApplianceʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class MedicalAppliance {
  private int id;//����ID
  private int medicalApplianceId;//ҽ����еID
  private String medicalApplianceName;//ѧ��
  private String medicalAppliancePrice;//�۸�
  private String medicalApplianceAmount;//���
  private String medicalApplianceCompany;//����
  private Date medicalApplianceExp;//��������
  private int delFlag;//ɾ�����
  private String more;//��ע
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
   * @return the medicalApplianceName
   */
  public String getMedicalApplianceName() {
    return medicalApplianceName;
  }
  /**
   * @param medicalApplianceName the medicalApplianceName to set
   */
  public void setMedicalApplianceName(String medicalApplianceName) {
    this.medicalApplianceName = medicalApplianceName;
  }
  /**
   * @return the medicalAppliancePrice
   */
  public String getMedicalAppliancePrice() {
    return medicalAppliancePrice;
  }
  /**
   * @param medicalAppliancePrice the medicalAppliancePrice to set
   */
  public void setMedicalAppliancePrice(String medicalAppliancePrice) {
    this.medicalAppliancePrice = medicalAppliancePrice;
  }
  /**
   * @return the medicalApplianceAmount
   */
  public String getMedicalApplianceAmount() {
    return medicalApplianceAmount;
  }
  /**
   * @param medicalApplianceAmount the medicalApplianceAmount to set
   */
  public void setMedicalApplianceAmount(String medicalApplianceAmount) {
    this.medicalApplianceAmount = medicalApplianceAmount;
  }
  /**
   * @return the medicalApplianceCompany
   */
  public String getMedicalApplianceCompany() {
    return medicalApplianceCompany;
  }
  /**
   * @param medicalApplianceCompany the medicalApplianceCompany to set
   */
  public void setMedicalApplianceCompany(String medicalApplianceCompany) {
    this.medicalApplianceCompany = medicalApplianceCompany;
  }
  /**
   * @return the medicalApplianceExp
   */
  public Date getMedicalApplianceExp() {
    return medicalApplianceExp;
  }
  /**
   * @param medicalApplianceExp the medicalApplianceExp to set
   */
  public void setMedicalApplianceExp(Date medicalApplianceExp) {
    this.medicalApplianceExp = medicalApplianceExp;
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
  /**
   * @return the more
   */
  public String getMore() {
    return more;
  }
  /**
   * @param more the more to set
   */
  public void setMore(String more) {
    this.more = more;
  }
  
}
