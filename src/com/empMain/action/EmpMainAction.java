package com.empMain.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName������
 * @Description:��Ĺ�������
 * @Author:����
 * @Since: ��������
 * @Version:�汾
 */
@Controller
@RequestMapping("/empMain")
public class EmpMainAction {
  //Ϊ��ʾҳ��Ч���ã���תһ��jsp(ҽ����)
  @RequestMapping(value="/showPage",method={ RequestMethod.GET,RequestMethod.POST})
  public String showShowEmp(){
    return "emp/showPage";
  }
  //Ϊ��ʾҳ��Ч���ã���תһ��jsp(��������)
  @RequestMapping(value="/showPageCustomer",method={ RequestMethod.GET,RequestMethod.POST})
  public String showShowCustomer(){
    return "customer/showPageCustomer";
  }
  
  //����ҽ��չʾ�˵��б��Action  //ҽ��Ϊ��emp/empMenu
  @RequestMapping(value="/empMenuList",method={ RequestMethod.GET,RequestMethod.POST})
  public String empMenuList(){
      return "emp/empMenu";
  }
  //����������չʾ�˵��б�Action //������Ϊ��customer/customerMenu
  @RequestMapping(value="/customerMenuList",method={ RequestMethod.GET,RequestMethod.POST})
  public String customerMenuList(){
      return "customer/customerMenu";
  }
}
