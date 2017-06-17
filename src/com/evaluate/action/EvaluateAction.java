package com.evaluate.action;

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

import com.drug.service.DrugService;
import com.evaluate.service.EvaluateService;
import com.loginAndRegist.service.LoginAndRegistService;
import com.medicalAppliance.service.MedicalApplianceService;
import com.salary.service.SalaryService;

import entity.Drug;
import entity.Evaluate;
import entity.MedicalAppliance;
import entity.ReplyEvaluate;
import entity.Salary;
import entity.User;
@Controller
@RequestMapping("/evaluate")
public class EvaluateAction {
	@Resource(name="evaluateServiceImpl")
	  private EvaluateService evaluateServiceImpl;
	@Resource(name="drugServiceImpl")
	private DrugService drugServiceImpl;
	@Resource(name="medicalApplianceServiceImpl")
	private MedicalApplianceService medicalApplianceServiceImpl;
	@Resource(name="salaryServiceImpl")
	private SalaryService salaryServiceImpl;
	 @Resource(name="loginAndRegistServiceImpl")
	  private LoginAndRegistService loginAndRegistServiceImpl;
	  
	  public void setLoginAndRegistServiceImpl(LoginAndRegistService loginAndRegistServiceImpl) {
	    this.loginAndRegistServiceImpl = loginAndRegistServiceImpl;
	  }
	public void setSalaryServiceImpl(SalaryService salaryServiceImpl) {
		this.salaryServiceImpl = salaryServiceImpl;
	}
	public void setMedicalApplianceServiceImpl(MedicalApplianceService medicalApplianceServiceImpl) {
		this.medicalApplianceServiceImpl = medicalApplianceServiceImpl;
	}
	public void setDrugServiceImpl(DrugService drugServiceImpl) {
		this.drugServiceImpl = drugServiceImpl;
	}
	public void setEvaluateServiceImpl(EvaluateService evaluateServiceImpl) {
		this.evaluateServiceImpl = evaluateServiceImpl;
	}
	@RequestMapping(value="/myEvaluateList",method={ RequestMethod.GET,RequestMethod.POST})
	public String myEvaluateList(HttpSession session,Model model){
		int userId=(int) session.getAttribute("userId");
		List<Evaluate>evaluateList=evaluateServiceImpl.findAllEvaluateByDoctorId(userId);
		model.addAttribute("evaluateList", evaluateList);
		return "emp/evaluateList";
	}
	
	@RequestMapping(value="/replyEvaluate",method={ RequestMethod.GET,RequestMethod.POST})
	public String replyEvaluate(String sickerId,Model model,String id){
		model.addAttribute("sickerId", sickerId);
		model.addAttribute("id", id);
		return "emp/replyEvaluate";
	}
	@RequestMapping(value="/replyEvaluateTwo",method={ RequestMethod.GET,RequestMethod.POST})
	public String replyEvaluateTwo(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException, ParseException{
		request.setCharacterEncoding("gbk");
		String content=request.getParameter("content");
		int sickerId=Integer.parseInt(request.getParameter("sickerId"));
		int doctorId=(int) session.getAttribute("userId");
		String time1=request.getParameter("time");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date time=sdf.parse(time1);
		int id=Integer.parseInt(request.getParameter("id"));
		ReplyEvaluate r=new ReplyEvaluate();
		r.setEid(id);
		r.setSickerId(sickerId);
		r.setDoctorId(doctorId);
		r.setContent(content);
		r.setTime(time);
		evaluateServiceImpl.replyEvaluate(r);
		evaluateServiceImpl.updateStatus(id);
		return "redirect:myEvaluateList.do";
	}
	@RequestMapping(value="/allDrug",method={ RequestMethod.GET,RequestMethod.POST})
	public String allDrug(Model model){
		List<Drug>drugList=drugServiceImpl.findAllDrug();
		model.addAttribute("drugList", drugList);
		return "emp/drugList";
	}
	
	@RequestMapping(value="/allAppliance",method={ RequestMethod.GET,RequestMethod.POST})
	public String allAppliance(Model model){
		List<MedicalAppliance>list=medicalApplianceServiceImpl.findAllMedicalAppliance();
		model.addAttribute("list", list);
		return "emp/medicalAppliance";
	}
	
	@RequestMapping(value="/mySalary",method={ RequestMethod.GET,RequestMethod.POST})
	public String mySalary(HttpSession session,Model model){
		int doctorId=(int) session.getAttribute("userId");
		List<Salary>list=salaryServiceImpl.findMySalary(doctorId);
		model.addAttribute("list", list);
		return "emp/mySalary";
	}
	@RequestMapping(value="/cusEvaluateList",method={ RequestMethod.GET,RequestMethod.POST})
	public String cusEvaluateList(HttpSession session,Model model){
		int userId=(int) session.getAttribute("userId");
		List<Evaluate>evaluateList=evaluateServiceImpl.findAllEvaluateBySickerId(userId);
		model.addAttribute("evaluateList", evaluateList);
		return "customer/cusEvaluateList";
	}
	
	@RequestMapping(value="/seeReplyEvaluate",method={ RequestMethod.GET,RequestMethod.POST})
	public String seeReplyEvaluate(HttpServletRequest request,Model model){
		int	 eid=Integer.parseInt(request.getParameter("eid"));
		ReplyEvaluate replyList=evaluateServiceImpl.seeReplyEvaluate(eid);
		model.addAttribute("replyList", replyList);
		return "customer/cusSeeEvaluate";
	}
	
	@RequestMapping(value="/addEvaluate",method={ RequestMethod.GET,RequestMethod.POST})
	public String addEvaluate(Model model,HttpSession session){
		String userName=(String) session.getAttribute("userName");
		model.addAttribute("userName", userName);
		  List<User>list=loginAndRegistServiceImpl.findAllDoctor();
		  model.addAttribute("list", list);
		return "customer/cusAddEvaluate";
	}
	@RequestMapping(value="/addEvaluateTwo",method={ RequestMethod.GET,RequestMethod.POST})
	public String addEvaluateTwo(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, ParseException{
		request.setCharacterEncoding("gbk");
		String time1=request.getParameter("reTime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date time=sdf.parse(time1);
		int sickerId=(int) session.getAttribute("userId");
		String remark=request.getParameter("remark");
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
		Evaluate ee=new Evaluate();
		ee.setSickId(sickerId);
		ee.setDoctorId(doctorId);
		ee.setEvaluateDetails(remark);
		ee.setEvaluateTime(time);
		evaluateServiceImpl.insertEvaluate(ee);
		return "redirect:cusEvaluateList.do";
	}
	
	@RequestMapping(value="/seeDoctorEvlatueList",method={ RequestMethod.GET,RequestMethod.POST})
	public String seeDoctorEvlatueList(HttpServletRequest request,Model model){
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
		List<Evaluate>list=evaluateServiceImpl.cusSeeDoctorEvaluate(doctorId);
		model.addAttribute("list", list);
		return "customer/sickerSeeEvaluate";
		
	}
	
}
