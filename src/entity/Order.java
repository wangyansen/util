package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName��Order
 * @Description:Orderʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Order {
  private int id;//����ID
  private int orderId;//ԤԼ��ID
  private int sickId;//����ID
  private int doctorId;//ҽ��ID
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date orderTime;//ԤԼʱ��
  private int orderStatus;//ԤԼ״̬��0�������룬1ԤԼ�ɹ�������ʱΪ0
  private int delFlag;//ɾ�����
  private String remark;//��ע
  private User user;//ע��USER��
  
  
  public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
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
   * @return the orderId
   */
  public int getOrderId() {
    return orderId;
  }
  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(int orderId) {
    this.orderId = orderId;
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
   * @return the orderTime
   */
  public Date getOrderTime() {
    return orderTime;
  }
  /**
   * @param orderTime the orderTime to set
   */
  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }
  /**
   * @return the orderStatus
   */
  public int getOrderStatus() {
    return orderStatus;
  }
  /**
   * @param orderStatus the orderStatus to set
   */
  public void setOrderStatus(int orderStatus) {
    this.orderStatus = orderStatus;
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
