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
 * @ClassName��LoginAndRegistServiceImpl
 * @Description:��¼ע��ҵ���ӿ�ʵ����
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
//�û�ע��
  @Override
  public boolean userLogin(User user) {
    if (loginAndRegistDao.addUser(user)>0) {
      return true;
    }
      return false;
  }
//�ж������Ƿ���ȷ����¼�ã��޸�����ǰҲ�ã�
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
//�жϵ�¼�û��Ľ�ɫ���Խ��벻ͬ�Ĳ˵��б�emp---0;customer---1;
  @Override
  public int judgeUserRole(String loginKey, String password) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("loginKey", loginKey);
    params.put("password", password);
    User user=loginAndRegistDao.judgeUserRole(params);
    if (user==null) {
		return 2;//û������û�
	}
    if (user.getRoleId()==0) {
      return 0;
    }
    return 1;
  }
//�û��޸�����
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
