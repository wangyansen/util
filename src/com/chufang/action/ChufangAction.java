package com.chufang.action;

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

import com.chufang.service.ChuFangService;
import com.drug.service.DrugService;
import com.medicalAppliance.service.MedicalApplianceService;

import entity.ChuFang;
import entity.Drug;
import entity.MedicalAppliance;

/**
 * @ClassName：类名
 * @Description:类的功能描述
 * @Author:作者
 * @Since: 作成日期
 * @Version:版本
 */
@Controller
@RequestMapping("/chufang")
public class ChufangAction {
	  @Resource(name="chuFangServiceImpl")
	  private ChuFangService chuFangServiceImpl;
	  @Resource(name="drugServiceImpl")
	  private DrugService drugServiceImpl;
	  @Resource(name="medicalApplianceServiceImpl")
	  private MedicalApplianceService medicalApplianceServiceImpl;
	  
  public void setDrugServiceImpl(DrugService drugServiceImpl) {
		this.drugServiceImpl = drugServiceImpl;
	}

	public void setMedicalApplianceServiceImpl(MedicalApplianceService medicalApplianceServiceImpl) {
		this.medicalApplianceServiceImpl = medicalApplianceServiceImpl;
	}

public void setChuFangServiceImpl(ChuFangService chuFangServiceImpl) {
		this.chuFangServiceImpl = chuFangServiceImpl;
	}

//处方列表的Action
  @RequestMapping(value="/chufangList",method={ RequestMethod.GET,RequestMethod.POST})
  public String chufangList(HttpSession session,Model model){
	  int userId=(int) session.getAttribute("userId");
	  String userName=(String) session.getAttribute("userName");
	  model.addAttribute("userName", userName);
	  List<ChuFang>chufangList= chuFangServiceImpl.findAllChufang(userId);
	  model.addAttribute("chufangList", chufangList);
      return "emp/chufangList";
  }
  
  //新增处方的Action
  //查出所有药品和医疗器械，以供下拉列表展示
  //得到session中的登陆人名字
  @RequestMapping(value="chufangAdd",method={RequestMethod.GET,RequestMethod.POST})
  public String chufangAdd(HttpSession session,Model model){
	  String userName=(String) session.getAttribute("userName");
	  model.addAttribute("userName", userName);
	  List<Drug>drugList=drugServiceImpl.findAllDrug();
	  model.addAttribute("drugList", drugList);
	  List<MedicalAppliance>medicalApplianceList=medicalApplianceServiceImpl.findAllMedicalAppliance();
	  model.addAttribute("medicalApplianceList", medicalApplianceList);
    return "emp/chufangAdd";
  }
  @RequestMapping(value="chufangAddTwo",method={RequestMethod.GET,RequestMethod.POST})
  public String chufangAddTwo(HttpServletRequest request,HttpSession session) throws ParseException, UnsupportedEncodingException{
	  request.setCharacterEncoding("gbk");
	  int userId=(int) session.getAttribute("userId");
	  String doctorName=request.getParameter("doctorName");
	  String sickerName=request.getParameter("sickerName");
	  String sickName=request.getParameter("sickName");
	  String price=request.getParameter("price");
	  String drugId1=request.getParameter("drugId");
	  String medicalApplianceId1=request.getParameter("medicalApplianceId");
	  String openTime1=request.getParameter("openTime");
	  String remark=request.getParameter("remark");
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  Date openTime=sdf.parse(openTime1);
	  int drugId=Integer.parseInt(drugId1);
	  int medicalApplianceId=Integer.parseInt(medicalApplianceId1);
	  ChuFang chufang=new ChuFang();
	  chufang.setDoctorName(doctorName);
	  chufang.setSickerName(sickerName);
	  chufang.setSickName(sickName);
	  chufang.setPrice(price);
	  chufang.setRemark(remark);
	  chufang.setOpenTime(openTime);
	  chufang.setDrugId(drugId);
	  chufang.setMedicalApplianceId(medicalApplianceId);
	  chufang.setDoctorId(userId);
	  chuFangServiceImpl.addChuFang(chufang);
	return "redirect:chufangList.do";
  }
  @RequestMapping(value="updateChufangOne",method={RequestMethod.GET,RequestMethod.POST})
  public String updateChufangOne(String chufangId,Model model){
	  int id=Integer.parseInt(chufangId);
	  ChuFang chufang= chuFangServiceImpl.findChuFangById(id);
	  model.addAttribute("chufang", chufang);
	  List<Drug>drugList=drugServiceImpl.findAllDrug();
	  model.addAttribute("drugList", drugList);
	  List<MedicalAppliance>medicalApplianceList=medicalApplianceServiceImpl.findAllMedicalAppliance();
	  model.addAttribute("medicalApplianceList", medicalApplianceList);
	return "emp/chufangUpdate";
  }
  @RequestMapping(value="chufangUpdateTwo",method={RequestMethod.GET,RequestMethod.POST})
  public String chufangUpdateTwo(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, ParseException{
	  request.setCharacterEncoding("gbk");
	  int userId=(int) session.getAttribute("userId");
	  String id=request.getParameter("id");
	  String doctorName=request.getParameter("doctorName");
	  String sickerName=request.getParameter("sickerName");
	  String sickName=request.getParameter("sickName");
	  String price=request.getParameter("price");
	  String drugId1=request.getParameter("drugId");
	  String medicalApplianceId1=request.getParameter("medicalApplianceId");
	  String openTime1=request.getParameter("openTime");
	  String remark=request.getParameter("remark");
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  Date openTime=sdf.parse(openTime1);
	  int drugId=Integer.parseInt(drugId1);
	  int medicalApplianceId=Integer.parseInt(medicalApplianceId1);
	  ChuFang chufang=new ChuFang();
	  chufang.setDoctorName(doctorName);
	  chufang.setSickerName(sickerName);
	  chufang.setSickName(sickName);
	  chufang.setPrice(price);
	  chufang.setRemark(remark);
	  chufang.setOpenTime(openTime);
	  chufang.setDrugId(drugId);
	  chufang.setMedicalApplianceId(medicalApplianceId);
	  chufang.setDoctorId(userId);
	  chufang.setId(Integer.parseInt(id));
	  chuFangServiceImpl.updateChufang(chufang);
	return "redirect:chufangList.do";
  }
  @RequestMapping(value="deleteChufang",method={RequestMethod.GET,RequestMethod.POST})
  public String deleteChufang(String chufangId){
	  chuFangServiceImpl.deteteChufang(Integer.parseInt(chufangId));
	return "redirect:chufangList.do";
  }
  @RequestMapping(value="findChufangListBySickerName",method={RequestMethod.GET,RequestMethod.POST})
  public String findChufangListBySickerName(HttpServletRequest request,HttpSession session,Model model) throws UnsupportedEncodingException{
	  request.setCharacterEncoding("gbk");
	  int doctorId=(int) session.getAttribute("userId");
	  String sickerName=request.getParameter("sickerName");
	  List<ChuFang>chufangList=chuFangServiceImpl.findChufangListBySickerName(sickerName, doctorId);
	  model.addAttribute("chufangList", chufangList);
	return "emp/chufangList";
  }
  @RequestMapping(value="cusChufangList",method={RequestMethod.GET,RequestMethod.POST})
  public String cusChufangList (HttpSession session,Model model){
	  String sickerName=(String) session.getAttribute("userName");
	  List<ChuFang>chufangList=chuFangServiceImpl.cusFindChufangList(sickerName);
	  model.addAttribute("chufangList", chufangList);
	return "customer/cusChufangList";
  }
}
