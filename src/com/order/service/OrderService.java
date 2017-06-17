package com.order.service;

import java.util.List;


import entity.Order;

public interface OrderService {
	List<Order>findAllOrderByDoctorId(int doctorId);
	int agreeOrder(int id);
	List<Order>findAllOldOrderByDoctorId(int doctorId);
	int deleteThisOrder(int id);
	List<Order>findNewOrderBySickerName(String sickerName,int doctorId);
	List<Order>findOldOrderBySickerName(String sickerName,int doctorId);
	List<Order>findAllOrderBySickerId(int sickerId);
	List<Order>findOrderByDoctorName(String doctorName,int sickerId);
	int addOrder(Order order);
	Order findOrderById(int id);
	int updateOrder(Order order);

}
