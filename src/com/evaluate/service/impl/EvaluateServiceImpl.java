package com.evaluate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.evaluate.dao.EvaluateDao;
import com.evaluate.service.EvaluateService;

import entity.Evaluate;
import entity.ReplyEvaluate;
@Service
public class EvaluateServiceImpl implements EvaluateService {
	private static Logger logger =Logger.getLogger(EvaluateServiceImpl.class);
	@Resource(name="evaluateDao")
	  private EvaluateDao evaluateDao;
	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}
	@Override
	public List<Evaluate> findAllEvaluateByDoctorId(int id) {
		List<Evaluate>list=evaluateDao.findAllEvaluateByDoctorId(id);
		logger.debug(list.size());
		return list;
	}
	@Override
	public int replyEvaluate(ReplyEvaluate replyEvaluate) {
		return evaluateDao.replyEvaluate(replyEvaluate);
	}
	@Override
	public int updateStatus(int id) {
		return evaluateDao.updateStatus(id);
	}
	@Override
	public List<Evaluate> findAllEvaluateBySickerId(int id) {
		return evaluateDao.findAllEvaluateBySickerId(id);
	}
	@Override
	public ReplyEvaluate seeReplyEvaluate(int eid) {
		return evaluateDao.seeReplyEvaluate(eid);
	}
	@Override
	public int insertEvaluate(Evaluate evaluate) {
		return evaluateDao.insertEvaluate(evaluate);
	}
	@Override
	public List<Evaluate> cusSeeDoctorEvaluate(int doctorId) {
		return evaluateDao.cusSeeDoctorEvaluate(doctorId);
	}
	

}
