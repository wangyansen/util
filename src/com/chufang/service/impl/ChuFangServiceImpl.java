package com.chufang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.chufang.dao.ChuFangDao;
import com.chufang.service.ChuFangService;

import entity.ChuFang;
@Service
public class ChuFangServiceImpl implements ChuFangService {
	private static Logger logger =Logger.getLogger(ChuFangServiceImpl.class);
	@Resource(name="chuFangDao")
	  private ChuFangDao chuFangDao;
	
	public void setChuFangDao(ChuFangDao chuFangDao) {
		this.chuFangDao = chuFangDao;
	}
	@Override
	public int addChuFang(ChuFang chufang) {
		int aa=chuFangDao.addChuFang(chufang);
		logger.debug("end");
		return aa;
	}
	@Override
	public List<ChuFang> findAllChufang(int userId) {
		List<ChuFang> list=chuFangDao.findAllChuFangList(userId);
		return list;
	}
	@Override
	public ChuFang findChuFangById(int id) {
		ChuFang chufang=chuFangDao.findChuFangById(id);
		logger.debug("end");
		return chufang;
	}
	@Override
	public int updateChufang(ChuFang chufang) {
		return chuFangDao.updateChufang(chufang);
	}
	@Override
	public int deteteChufang(int id) {
		return chuFangDao.deleteChufang(id);
	}
	@Override
	public List<ChuFang> findChufangListBySickerName(String sickerName, int doctorId) {
		List<ChuFang> list=chuFangDao.findChufangListBySickerName(sickerName, doctorId);
		return list;
	}
	@Override
	public List<ChuFang> cusFindChufangList(String sickerName) {
		return chuFangDao.cusFindChufangList(sickerName);
	}

}
