package entity;

import java.util.Date;

/**
 * @ClassName��Evaluate
 * @Description:Evaluateʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Evaluate {
  private int id;//����ID
  private int sickId;//����ID
  private int doctorId;//ҽ��ID
  private String evaluateDetails;//��������
  private Date evaluateTime;//����ʱ��
  private int delFlag;//ɾ�����
  private User user;
  
  
  public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
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
   * @return the sickId
   */
  public int getSickId() {
    return sickId;
  }
  /**
   * @param sickId the sickId to set
   */
  public void setSickId(int sickId) {
    this.sickId = sickId;
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
   * @return the evaluateDetails
   */
  public String getEvaluateDetails() {
    return evaluateDetails;
  }
  /**
   * @param evaluateDetails the evaluateDetails to set
   */
  public void setEvaluateDetails(String evaluateDetails) {
    this.evaluateDetails = evaluateDetails;
  }
  /**
   * @return the evaluateTime
   */
  public Date getEvaluateTime() {
    return evaluateTime;
  }
  /**
   * @param evaluateTime the evaluateTime to set
   */
  public void setEvaluateTime(Date evaluateTime) {
    this.evaluateTime = evaluateTime;
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
