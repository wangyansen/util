package entity;

import java.util.Date;

public class ReplyEvaluate {
	private int id;//主键
	private int sickerId;//患者ID
	private int doctorId;//医生ID
	private String content;//回复内容
	private Date time;//回复时间
	private int statu;//状态（暂时不用）
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
