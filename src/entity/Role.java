package entity;

/**
 * @ClassName��Role
 * @Description:Role��ʵ����
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Role {
  private int id;//����ID
  private int roleId;//��ɫID
  private String roleName;//��ɫ����
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
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }
  /**
   * @param roleName the roleName to set
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
}
