package entity;

/**
 * @ClassName：Menu
 * @Description:Menu的实体类
 * @Author:wys
 * @Since: 2016-02-25
 * @Version:1.0
 */
public class Menu {
  private int id;//主键ID
  private int menuId;//菜单ID
  private String menuName;//菜单名称
  private String menuUrl;//菜单URL
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
   * @return the menuId
   */
  public int getMenuId() {
    return menuId;
  }
  /**
   * @param menuId the menuId to set
   */
  public void setMenuId(int menuId) {
    this.menuId = menuId;
  }
  /**
   * @return the menuName
   */
  public String getMenuName() {
    return menuName;
  }
  /**
   * @param menuName the menuName to set
   */
  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }
  /**
   * @return the menuUrl
   */
  public String getMenuUrl() {
    return menuUrl;
  }
  /**
   * @param menuUrl the menuUrl to set
   */
  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }
  
}
