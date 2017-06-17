package com.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Order;

public interface OrderDao {
	List<Order>findAllOrderByDoctorId(int doctorId);
	int agreeOrder(int id);
	List<Order>findAllOldOrderByDoctorId(int doctorId);
	int deleteThisOrder(int id);
	List<Order>findNewOrderBySickerName(@Param("sickerName")String sickerName,@Param("doctorId")int doctorId);
	List<Order>findOldOrderBySickerName(@Param("sickerName")String sickerName,@Param("doctorId")int doctorId);
	List<Order>findAllOrderBySickerId(int sickerId);
	List<Order>findOrderByDoctorName(@Param("doctorName")String doctorName,@Param("sickerId")int sickerId);
	int addOrder(Order order);
	Order findOrderById(int id);
	int updateOrder(Order order);

}
