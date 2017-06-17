package com.loginAndRegist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loginAndRegist.dao.LoginAndRegistDao;
import com.loginAndRegist.service.LoginAndRegistService;

import entity.User;

/**
 * @ClassName：LoginAndRegistServiceImpl
 * @Description:登录注册业务层接口实现类
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
@Service
public class LoginAndRegistServiceImpl implements LoginAndRegistService {
	private static Logger logger =Logger.getLogger(LoginAndRegistServiceImpl.class);
  @Resource(name="loginAndRegistDao")
  private LoginAndRegistDao loginAndRegistDao;
  
  public void setLoginAndRegistDao(LoginAndRegistDao loginAndRegistDao) {
    this.loginAndRegistDao = loginAndRegistDao;
  }
//用户注册
  @Override
  public boolean userLogin(User user) {
    if (loginAndRegistDao.addUser(user)>0) {
      return true;
    }
      return false;
  }
//判断密码是否正确（登录用，修改密码前也用）
  @Override
  public boolean judgePassword(String loginKey, String password) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("loginKey", loginKey);
    params.put("password", password);
    logger.debug("judgePassword begin");
    int result=loginAndRegistDao.judgePassword(params);
    logger.debug("judgePassword end");
    if(result>0){
      return true;
    }
    return false;
  }
//判断登录用户的角色，以进入不同的菜单列表emp---0;customer---1;
  @Override
  public int judgeUserRole(String loginKey, String password) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("loginKey", loginKey);
    params.put("password", password);
    User user=loginAndRegistDao.judgeUserRole(params);
    if (user==null) {
		return 2;//没有这个用户
	}
    if (user.getRoleId()==0) {
      return 0;
    }
    return 1;
  }
//用户修改密码
  @Override
  public boolean changePassword(String loginKey, String newPassword) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("loginKey", loginKey);
    params.put("newPassword", newPassword);
    if(loginAndRegistDao.changePassword(params)>0){
      return true;
    }
    return false;
  }
@Override
public User findUserByKey(String loginKey, String password) {
	Map<String, Object> params = new HashMap<String, Object>();
    params.put("loginKey", loginKey);
    params.put("password", password);
	return loginAndRegistDao.findUserByKey(params);
}
@Override
public List<User> findAllDoctor() {
	return loginAndRegistDao.findAllDoctor();
}
@Override
public List<User> findAllDoctorByName(String doctorName) {
	return loginAndRegistDao.findAllDoctorByName(doctorName);
}



}
