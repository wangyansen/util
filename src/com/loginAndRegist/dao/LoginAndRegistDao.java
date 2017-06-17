package com.loginAndRegist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.User;

/**
 * @ClassName：LoginAndRegistDao
 * @Description:登录注册所使用的方法
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
public interface LoginAndRegistDao {
//  注册新用户
  int addUser(User user);
 // 修改密码
  int changePassword(Map<String, Object> params);
  //输入账号密码，判断用户是何种类型，emp---0;customer---1;
  User judgeUserRole(Map<String, Object> params);
  // 判断密码是否正确(登录用，修改密码前也用)
  int judgePassword(Map<String, Object> params);
  //根据账号密码查询用户所有信息
  User findUserByKey(Map<String, Object> params);
  List<User> findAllDoctor();
  List<User>findAllDoctorByName(@Param("doctorName")String doctorName);
  
}
