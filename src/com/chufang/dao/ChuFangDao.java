package com.chufang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ChuFang;

public interface ChuFangDao {
	//��������
	int addChuFang(ChuFang chufang);
	//��ѯ�ҵ���ʷ����
	List<ChuFang> findAllChuFangList(int userId);
	//��������id��ѯ������Ϣ
	ChuFang findChuFangById(int id);
	//�޸Ĵ���
	int updateChufang(ChuFang chufang);
	//����ɾ����ǣ���ɾ������
	int deleteChufang(int id);
	//ģ����ѯ
	List<ChuFang> findChufangListBySickerName(@Param("sickerName")String sickerName,@Param("doctorId")int doctorId);
	//�û���ѯ�ҵ����Ѽ�¼
	List<ChuFang> cusFindChufangList(@Param("sickerName")String sickerName);
}
