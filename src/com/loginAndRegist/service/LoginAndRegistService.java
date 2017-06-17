package com.loginAndRegist.service;


import java.util.List;


import entity.User;

/**
 * @ClassName：LoginAndRegistService
 * @Description:登录注册业务层接口
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
public interface LoginAndRegistService {
  
  //用户注册
  boolean userLogin(User user);
  
  //用户修改密码
  boolean changePassword(String loginKey,String newPassword);
  
  //判断登录用户的角色，以进入不同的菜单列表 emp---0;customer---1;
  int judgeUserRole(String loginKey,String password);
  
  //判断密码是否正确（登录用，修改密码前也用）
  boolean judgePassword(String loginKey,String password);
  
  User findUserByKey(String loginKey,String password);
  List<User> findAllDoctor();
  List<User>findAllDoctorByName(String doctorName);
  

}
