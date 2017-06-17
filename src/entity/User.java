package entity;

/**
 * @ClassName：User
 * @Description:User实体类
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class User {
  private int id;//主键
  private int  userId;//用户ID
  private String userName;//用户姓名
  private int roleId;//相关的角色ID
  private String sex;//性别
  private String loginKey;//账号
  private String password;//密码
  private String phone;//电话
  private String adress;//地址
  private String univercity;//毕业院校
  private String experience;//工作经历
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
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }
  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }
  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }
  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /**
   * @return the roleId
   */
  public int getRoleId() {
    return roleId;
  }
  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }
  /**
   * @return the sex
   */
  public String getSex() {
    return sex;
  }
  /**
   * @param sex the sex to set
   */
  public void setSex(String sex) {
    this.sex = sex;
  }
  /**
   * @return the loginKey
   */
  public String getLoginKey() {
    return loginKey;
  }
  /**
   * @param loginKey the loginKey to set
   */
  public void setLoginKey(String loginKey) {
    this.loginKey = loginKey;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }
  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }
  /**
   * @return the adress
   */
  public String getAdress() {
    return adress;
  }
  /**
   * @param adress the adress to set
   */
  public void setAdress(String adress) {
    this.adress = adress;
  }
  /**
   * @return the univercity
   */
  public String getUnivercity() {
    return univercity;
  }
  /**
   * @param univercity the univercity to set
   */
  public void setUnivercity(String univercity) {
    this.univercity = univercity;
  }
  /**
   * @return the experience
   */
  public String getExperience() {
    return experience;
  }
  /**
   * @param experience the experience to set
   */
  public void setExperience(String experience) {
    this.experience = experience;
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
