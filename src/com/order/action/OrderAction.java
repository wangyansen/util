package com.order.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.order.service.OrderService;

import entity.Order;
import entity.User;

@Controller
@RequestMapping("/order")
public class OrderAction {
	  @Resource(name="orderServiceImpl")
	  private OrderService orderServiceImpl;
	  @Resource(name="loginAndRegistServiceImpl")
	  private LoginAndRegistService loginAndRegistServiceImpl;
	  
	  public void setLoginAndRegistServiceImpl(LoginAndRegistService loginAndRegistServiceImpl) {
	    this.loginAndRegistServiceImpl = loginAndRegistServiceImpl;
	  }

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}
	 //进入我的新增预约单列表
	@RequestMapping(value="/myNewOrderList",method={ RequestMethod.GET,RequestMethod.POST})
	  public String myNewOrderList(HttpSession session,Model model){
		int doctorId=(int) session.getAttribute("userId");
		List<Order>orderList=orderServiceImpl.findAllOrderByDoctorId(doctorId);
		model.addAttribute("orderList", orderList);
	      return "emp/orderList";
	  }  
	//同意此预约
	@RequestMapping(value="/agreeOrder",method={ RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String agreeOrder(HttpServletRequest request){
		String orderId=request.getParameter("id");
		int id=Integer.parseInt(orderId);
		orderServiceImpl.agreeOrder(id);
		return "00";
	}
	//进入我已同意的预约单列表 
	@RequestMapping(value="/myOldOrderList",method={ RequestMethod.GET,RequestMethod.POST})
	public String myOldOrderList(HttpSession session,Model model){
		int doctorId=(int) session.getAttribute("userId");
		List<Order>orderList=orderServiceImpl.findAllOldOrderByDoctorId(doctorId);
		model.addAttribute("orderList", orderList);
		return "emp/oldOrderList";
	}
	//删除此预约记录
	@RequestMapping(value="/deleteThisOrder",method={ RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String deleteThisOrder(HttpServletRequest request){
		String orderId=request.getParameter("id");
		int id=Integer.parseInt(orderId);
		orderServiceImpl.deleteThisOrder(id);
		return "00";
	}
	//模糊查询
	
	@RequestMapping(value="/findOrderBySickerName",method={ RequestMethod.GET,RequestMethod.POST})
	public String findOrderBySickerName(HttpServletRequest request,Model model,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("gbk");
		String mark=request.getParameter("mark");
		int doctorId=(int) session.getAttribute("userId");
		String sickerName=request.getParameter("sickerName");
		if (mark.equals("1")) {
			List<Order>orderList=orderServiceImpl.findNewOrderBySickerName(sickerName, doctorId);
			model.addAttribute("orderList", orderList);
			return "emp/orderList";
		}
		List<Order>orderList=orderServiceImpl.findOldOrderBySickerName(sickerName, doctorId);
		model.addAttribute("orderList", orderList);
		return "emp/oldOrderList";
		
	}
	//用户进入我的预约列表
	@RequestMapping(value="/cusOrderList",method={ RequestMethod.GET,RequestMethod.POST})
	public String cusOrderList(HttpSession session,Model model){
		int sickerId=(int) session.getAttribute("userId");
		List<Order>orderList=orderServiceImpl.findAllOrderBySickerId(sickerId);
		model.addAttribute("orderList", orderList);
		return "customer/cusOrderList";
	}
	//用户模糊查询预约列表
	@RequestMapping(value="/findOrderByDoctorName",method={ RequestMethod.GET,RequestMethod.POST})
	public String findOrderByDoctorName(HttpServletRequest request,Model model,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("gbk");
		int sickerId=(int) session.getAttribute("userId");
		String doctorName=request.getParameter("doctorName");
		List<Order>orderList=orderServiceImpl.findOrderByDoctorName(doctorName, sickerId);
		model.addAttribute("orderList", orderList);
		return "customer/cusOrderList";
	}
	//用户新增预约第一步
	@RequestMapping(value="/orderAdd",method={ RequestMethod.GET,RequestMethod.POST})
	public String orderAdd(HttpSession session,Model model){
		String userName=(String) session.getAttribute("userName");
		List<User>doctorList=loginAndRegistServiceImpl.findAllDoctor();
		model.addAttribute("userName", userName);
		model.addAttribute("doctorList", doctorList);
		return "customer/addOrder";
	}
	//用户新增预约第二步
	@RequestMapping(value="/orderAddTwo",method={ RequestMethod.GET,RequestMethod.POST})
	public String orderAddTwo(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, ParseException{
		request.setCharacterEncoding("gbk");
		int sickerId=(int) session.getAttribute("userId");
		String doctorId=request.getParameter("doctorId");
		String time=request.getParameter("orderTime");
		String remark=request.getParameter("remark");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date orderTime=sdf.parse(time);
		Order order=new Order();
		order.setSickId(sickerId);
		order.setDoctorId(Integer.parseInt(doctorId));
		order.setOrderTime(orderTime);
		order.setRemark(remark);
		orderServiceImpl.addOrder(order);
		return "redirect:cusOrderList.do";
	}
	//用户修改预约第一步
	@RequestMapping(value="/updateOrderOne",method={ RequestMethod.GET,RequestMethod.POST})
	public String updateOrderOne(HttpSession session,String id,Model model){
		List<User>doctorList=loginAndRegistServiceImpl.findAllDoctor();
		String userName=(String) session.getAttribute("userName");
		model.addAttribute("userName", userName);
		model.addAttribute("doctorList", doctorList);
		Order order=orderServiceImpl.findOrderById(Integer.parseInt(id));
		model.addAttribute("order", order);
		model.addAttribute("id", id);
		return "customer/updateOrder";
	}
	//用户修改预约第2步
	@RequestMapping(value="/updateOrderTwo",method={ RequestMethod.GET,RequestMethod.POST})
	public String updateOrderTwo(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, ParseException{
		request.setCharacterEncoding("gbk");
		int sickerId=(int) session.getAttribute("userId");
		String doctorId=request.getParameter("doctorId");
		String time=request.getParameter("orderTime");
		String remark=request.getParameter("remark");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date orderTime=sdf.parse(time);
		Order order=new Order();
		order.setId(Integer.parseInt(request.getParameter("id")));
		order.setSickId(sickerId);
		order.setDoctorId(Integer.parseInt(doctorId));
		order.setOrderTime(orderTime);
		order.setRemark(remark);
		orderServiceImpl.updateOrder(order);
		return "redirect:cusOrderList.do";
		
	}
}
