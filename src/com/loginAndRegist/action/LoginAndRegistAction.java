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
 * @ClassName：LoginAndRegistAction
 * @Description:登录注册模块的Action
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
  //登录action渲染画面
  @RequestMapping(value="/login",method={ RequestMethod.GET,RequestMethod.POST})
  public String login(){
      return "loginAndRegist/huaYuan";
  }
  //登录action
  @RequestMapping(value="/realLogin",method={ RequestMethod.GET,RequestMethod.POST})
  public String realLogin(){
	return "loginAndRegist/Login";
  }
  //注册Stap1-action
  @RequestMapping(value="/regist",method={ RequestMethod.GET,RequestMethod.POST})
  public String regist(){
    return "loginAndRegist/regist";
  }
  //注册Stap2-action
  @RequestMapping(value="/registTwo",method={ RequestMethod.GET,RequestMethod.POST})
  public String registTwo(HttpServletRequest request) throws UnsupportedEncodingException{
	  request.setCharacterEncoding("gbk");
    //如果成功，跳reg-result.jsp，否则（有校验）所以只有成功这一种情况
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
  //修改密码Stap1-action
  @RequestMapping(value="/changePasswordOne",method={ RequestMethod.GET,RequestMethod.POST})
  public  String changePasswordOne(){
   return "loginAndRegist/changePassword";
  }
  //修改密码Stap2，点击修改密码，触发的AJAX事件，判断账号密码是否正确 正确，返回11；不正确，返回00；
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
  //修改密码Stap3-action,做数据库操作
  @RequestMapping(value="/changePasswordThree",method={ RequestMethod.GET,RequestMethod.POST})
  public String changePasswordThree(HttpSession session){
	  String loginKey=(String) session.getAttribute("loginKey");
	  String newPassword=(String) session.getAttribute("newPassword");
	  loginAndRegistServiceImpl.changePassword(loginKey, newPassword);
    return "loginAndRegist/change-result";
  }
  //点击登录，处发的Ajax事件;登录失败---0;登录成功且为医生----11；登录成功且为消费者-----22;
  @RequestMapping(value="/dengluAjax",method={ RequestMethod.GET,RequestMethod.POST})
  public @ResponseBody String dengluAjax(String loginKey,String password,HttpSession session){
	  boolean bool = false;
	  int userRole = 0;
    //先验证账号密码是否正确
	  if (!"".equals(password)&&password!=null) {
		  bool=loginAndRegistServiceImpl.judgePassword(loginKey, password);
	}
    //再验证此账号的角色
	  if (!"".equals(password)&&password!=null) {
		  userRole=loginAndRegistServiceImpl.judgeUserRole(loginKey, password);
	}
	  //把基本信息SET进Session中
	  User user=loginAndRegistServiceImpl.findUserByKey(loginKey, password);
	  if(user!=null){
		  session.setAttribute("userId", user.getId());
		  session.setAttribute("userName", user.getUserName());
	  }
    //账号密码正确，且为医生
    if(bool&&userRole==0){
      return "11";
    }
    //账号密码正确，且为消费者
    if(bool&&userRole==1){
      return "22";
    }
    //账号密码不正确
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
