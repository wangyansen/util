package com.empMain.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName：类名
 * @Description:类的功能描述
 * @Author:作者
 * @Since: 作成日期
 * @Version:版本
 */
@Controller
@RequestMapping("/empMain")
public class EmpMainAction {
  //为显示页面效果用，跳转一个jsp(医生用)
  @RequestMapping(value="/showPage",method={ RequestMethod.GET,RequestMethod.POST})
  public String showShowEmp(){
    return "emp/showPage";
  }
  //为显示页面效果用，跳转一个jsp(消费者用)
  @RequestMapping(value="/showPageCustomer",method={ RequestMethod.GET,RequestMethod.POST})
  public String showShowCustomer(){
    return "customer/showPageCustomer";
  }
  
  //进入医生展示菜单列表的Action  //医生为：emp/empMenu
  @RequestMapping(value="/empMenuList",method={ RequestMethod.GET,RequestMethod.POST})
  public String empMenuList(){
      return "emp/empMenu";
  }
  //进入消费者展示菜单列表Action //消费者为：customer/customerMenu
  @RequestMapping(value="/customerMenuList",method={ RequestMethod.GET,RequestMethod.POST})
  public String customerMenuList(){
      return "customer/customerMenu";
  }
}
