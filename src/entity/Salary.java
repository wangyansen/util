package entity;

import java.util.Date;

/**
 * @ClassName��Salary
 * @Description:Salaryʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Salary {
  private int id;//����ID
  private int doctorId;//ҽ��ID
  private String baseSalary;//��������
  private String reward;//����
  private Date openTime;//���Ź���ʱ��
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
   * @return the doctorId
   */
  public int getDoctorId() {
    return doctorId;
  }
  /**
   * @param doctorId the doctorId to set
   */
  public void setDoctorId(int doctorId) {
    this.doctorId = doctorId;
  }
  /**
   * @return the baseSalary
   */
  public String getBaseSalary() {
    return baseSalary;
  }
  /**
   * @param baseSalary the baseSalary to set
   */
  public void setBaseSalary(String baseSalary) {
    this.baseSalary = baseSalary;
  }
  /**
   * @return the reward
   */
  public String getReward() {
    return reward;
  }
  /**
   * @param reward the reward to set
   */
  public void setReward(String reward) {
    this.reward = reward;
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
  
  
}
