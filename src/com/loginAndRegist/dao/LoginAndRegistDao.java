package com.loginAndRegist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.User;

/**
 * @ClassName��LoginAndRegistDao
 * @Description:��¼ע����ʹ�õķ���
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
public interface LoginAndRegistDao {
//  ע�����û�
  int addUser(User user);
 // �޸�����
  int changePassword(Map<String, Object> params);
  //�����˺����룬�ж��û��Ǻ������ͣ�emp---0;customer---1;
  User judgeUserRole(Map<String, Object> params);
  // �ж������Ƿ���ȷ(��¼�ã��޸�����ǰҲ��)
  int judgePassword(Map<String, Object> params);
  //�����˺������ѯ�û�������Ϣ
  User findUserByKey(Map<String, Object> params);
  List<User> findAllDoctor();
  List<User>findAllDoctorByName(@Param("doctorName")String doctorName);
  
}
