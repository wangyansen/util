package com.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.chufang.service.impl.ChuFangServiceImpl;
import com.order.dao.OrderDao;
import com.order.service.OrderService;

import entity.Order;
@Service
public class OrderServiceImpl implements OrderService {
	private static Logger logger =Logger.getLogger(ChuFangServiceImpl.class);
	@Resource(name="orderDao")
	  private OrderDao orderDao;
	
	@Override
	public List<Order> findAllOrderByDoctorId(int doctorId) {
		List<Order>list=orderDao.findAllOrderByDoctorId(doctorId);
		logger.debug(list.size());
		return list;
	}

	@Override
	public int agreeOrder(int id) {
		return orderDao.agreeOrder(id);
	}

	@Override
	public List<Order> findAllOldOrderByDoctorId(int doctorId) {
		List<Order>list=orderDao.findAllOldOrderByDoctorId(doctorId);
		logger.debug(list.size());
		return list;
	}

	@Override
	public int deleteThisOrder(int id) {
		return orderDao.deleteThisOrder(id);
	}

	@Override
	public List<Order> findNewOrderBySickerName(String sickerName, int doctorId) {
		List<Order>list=orderDao.findNewOrderBySickerName(sickerName, doctorId);
		return list;
	}

	@Override
	public List<Order> findOldOrderBySickerName(String sickerName, int doctorId) {
		List<Order>list=orderDao.findOldOrderBySickerName(sickerName, doctorId);
		return list;
	}

	@Override
	public List<Order> findAllOrderBySickerId(int sickerId) {
		return orderDao.findAllOrderBySickerId(sickerId);
	}

	@Override
	public List<Order> findOrderByDoctorName(String doctorName, int sickerId) {
		return orderDao.findOrderByDoctorName(doctorName, sickerId);
	}

	@Override
	public int addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	public Order findOrderById(int id) {
		return orderDao.findOrderById(id);
	}

	@Override
	public int updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}

}
