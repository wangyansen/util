package com.evaluate.service;

import java.util.List;

import entity.Evaluate;
import entity.ReplyEvaluate;

public interface EvaluateService {
	List<Evaluate>findAllEvaluateByDoctorId(int id);
	int replyEvaluate(ReplyEvaluate replyEvaluate);
	int updateStatus(int id);
	List<Evaluate>findAllEvaluateBySickerId(int id);
	ReplyEvaluate seeReplyEvaluate(int eid);
	int insertEvaluate(Evaluate evaluate);
	List<Evaluate>cusSeeDoctorEvaluate(int doctorId);
}
