package com.chufang.service;

import java.util.List;

import entity.ChuFang;

public interface ChuFangService {
	int addChuFang(ChuFang chufang);
	List<ChuFang> findAllChufang(int userId);
	ChuFang findChuFangById(int id);
	int updateChufang(ChuFang chufang);
	int deteteChufang(int id);
	List<ChuFang> findChufangListBySickerName(String sickerName,int doctorId);
	List<ChuFang> cusFindChufangList(String sickerName);

}
