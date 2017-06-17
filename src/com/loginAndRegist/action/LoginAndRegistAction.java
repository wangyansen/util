package com.loginAndRegist.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loginAndRegist.service.LoginAndRegistService;

import entity.User;

/**
 * @ClassName��LoginAndRegistAction
 * @Description:��¼ע��ģ���Action
 * @Author:wys
 * @Since: 2016-03-02
 * @Version:1.0
 */
@Controller
@RequestMapping("/welcome")
public class LoginAndRegistAction {
  
  @Resource(name="loginAndRegistServiceImpl")
  private LoginAndRegistService loginAndRegistServiceImpl;
  
  public void setLoginAndRegistServiceImpl(LoginAndRegistService loginAndRegistServiceImpl) {
    this.loginAndRegistServiceImpl = loginAndRegistServiceImpl;
  }
  //��¼action��Ⱦ����
  @RequestMapping(value="/login",method={ RequestMethod.GET,RequestMethod.POST})
  public String login(){
      return "loginAndRegist/huaYuan";
  }
  //��¼action
  @RequestMapping(value="/realLogin",method={ RequestMethod.GET,RequestMethod.POST})
  public String realLogin(){
	return "loginAndRegist/Login";
  }
  //ע��Stap1-action
  @RequestMapping(value="/regist",method={ RequestMethod.GET,RequestMethod.POST})
  public String regist(){
    return "loginAndRegist/regist";
  }
  //ע��Stap2-action
  @RequestMapping(value="/registTwo",method={ RequestMethod.GET,RequestMethod.POST})
  public String registTwo(HttpServletRequest request) throws UnsupportedEncodingException{
	  request.setCharacterEncoding("gbk");
    //����ɹ�����reg-result.jsp��������У�飩����ֻ�гɹ���һ�����
	  String userId=(String) request.getParameter("userId");
	  String userName=(String) request.getParameter("userName");
	  String password=(String) request.getParameter("password");
	  String sex=(String) request.getParameter("sex");
	  String email=(String) request.getParameter("email");
	  String mobile=(String) request.getParameter("mobile");
	  User user=new User();
	  user.setLoginKey(userId);
	  user.setUserName(userName);
	  user.setPassword(password);
	  user.setSex(sex);
	  user.setAdress(email);
	  user.setPhone(mobile);
	  loginAndRegistServiceImpl.userLogin(user);
    return "loginAndRegist/reg-result";
  }
  //�޸�����Stap1-action
  @RequestMapping(value="/changePasswordOne",method={ RequestMethod.GET,RequestMethod.POST})
  public  String changePasswordOne(){
   return "loginAndRegist/changePassword";
  }
  //�޸�����Stap2������޸����룬������AJAX�¼����ж��˺������Ƿ���ȷ ��ȷ������11������ȷ������00��
  @RequestMapping(value="/changePasswordTwo",method={ RequestMethod.GET,RequestMethod.POST})
  public @ResponseBody String changePasswordTwo(String loginKey,String password,String newPassword,HttpSession
		   session){
	  boolean bool=false;
	    bool=loginAndRegistServiceImpl.judgePassword(loginKey, password);
	    session.setAttribute("loginKey", loginKey);
	    session.setAttribute("newPassword", newPassword);
	    if(bool){
	    	return "11";
	    }
	   return "00";
  }
  //�޸�����Stap3-action,�����ݿ����
  @RequestMapping(value="/changePasswordThree",method={ RequestMethod.GET,RequestMethod.POST})
  public String changePasswordThree(HttpSession session){
	  String loginKey=(String) session.getAttribute("loginKey");
	  String newPassword=(String) session.getAttribute("newPassword");
	  loginAndRegistServiceImpl.changePassword(loginKey, newPassword);
    return "loginAndRegist/change-result";
  }
  //�����¼��������Ajax�¼�;��¼ʧ��---0;��¼�ɹ���Ϊҽ��----11����¼�ɹ���Ϊ������-----22;
  @RequestMapping(value="/dengluAjax",method={ RequestMethod.GET,RequestMethod.POST})
  public @ResponseBody String dengluAjax(String loginKey,String password,HttpSession session){
	  boolean bool = false;
	  int userRole = 0;
    //����֤�˺������Ƿ���ȷ
	  if (!"".equals(password)&&password!=null) {
		  bool=loginAndRegistServiceImpl.judgePassword(loginKey, password);
	}
    //����֤���˺ŵĽ�ɫ
	  if (!"".equals(password)&&password!=null) {
		  userRole=loginAndRegistServiceImpl.judgeUserRole(loginKey, password);
	}
	  //�ѻ�����ϢSET��Session��
	  User user=loginAndRegistServiceImpl.findUserByKey(loginKey, password);
	  if(user!=null){
		  session.setAttribute("userId", user.getId());
		  session.setAttribute("userName", user.getUserName());
	  }
    //�˺�������ȷ����Ϊҽ��
    if(bool&&userRole==0){
      return "11";
    }
    //�˺�������ȷ����Ϊ������
    if(bool&&userRole==1){
      return "22";
    }
    //�˺����벻��ȷ
      return "0";
  }
  @RequestMapping(value="/findAllDoctor",method={ RequestMethod.GET,RequestMethod.POST})
  public String findAllDoctor(HttpSession session,Model model){
	  List<User>list=loginAndRegistServiceImpl.findAllDoctor();
	  model.addAttribute("list", list);		
	return "customer/allDoctor";
	
  }
  @RequestMapping(value="/findAllDoctorByName",method={ RequestMethod.GET,RequestMethod.POST})
	 public String findAllDoctorByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException{
	  request.setCharacterEncoding("gbk");
	  String doctorName=request.getParameter("doctorName");
	  List<User>list=loginAndRegistServiceImpl.findAllDoctorByName(doctorName);
	  model.addAttribute("list", list);
		return "customer/allDoctor";
		 
		 
	 }
}
