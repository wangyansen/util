package com.chufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ChuFang;

public interface ChuFangDao {
	//新增处方
	int addChuFang(ChuFang chufang);
	//查询我的历史处方
	List<ChuFang> findAllChuFangList(int userId);
	//根据主键id查询处方信息
	ChuFang findChuFangById(int id);
	//修改处方
	int updateChufang(ChuFang chufang);
	//更改删除标记，即删除处方
	int deleteChufang(int id);
	//模糊查询
	List<ChuFang> findChufangListBySickerName(@Param("sickerName")String sickerName,@Param("doctorId")int doctorId);
	//用户查询我的消费记录
	List<ChuFang> cusFindChufangList(@Param("sickerName")String sickerName);
}
