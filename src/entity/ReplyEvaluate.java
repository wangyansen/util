package entity;

import java.util.Date;

public class ReplyEvaluate {
	private int id;//����
	private int sickerId;//����ID
	private int doctorId;//ҽ��ID
	private String content;//�ظ�����
	private Date time;//�ظ�ʱ��
	private int statu;//״̬����ʱ���ã�
	private int eid;
	private User user;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSickerId() {
		return sickerId;
	}
	public void setSickerId(int sickerId) {
		this.sickerId = sickerId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
