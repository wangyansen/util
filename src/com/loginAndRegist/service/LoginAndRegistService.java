package com.loginAndRegist.service;


import java.util.List;


import entity.User;

/**
 * @ClassName��LoginAndRegistService
 * @Description:��¼ע��ҵ���ӿ�
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
public interface LoginAndRegistService {
  
  //�û�ע��
  boolean userLogin(User user);
  
  //�û��޸�����
  boolean changePassword(String loginKey,String newPassword);
  
  //�жϵ�¼�û��Ľ�ɫ���Խ��벻ͬ�Ĳ˵��б� emp---0;customer---1;
  int judgeUserRole(String loginKey,String password);
  
  //�ж������Ƿ���ȷ����¼�ã��޸�����ǰҲ�ã�
  boolean judgePassword(String loginKey,String password);
  
  User findUserByKey(String loginKey,String password);
  List<User> findAllDoctor();
  List<User>findAllDoctorByName(String doctorName);
  

}
