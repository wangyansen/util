package com.salary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.salary.dao.SalaryDao;
import com.salary.service.SalaryService;

import entity.Salary;
@Service
public class SalaryServiceImpl implements SalaryService {
	private static Logger logger =Logger.getLogger(SalaryServiceImpl.class);
	@Resource(name="salaryDao")
	  private SalaryDao salaryDao;
	@Override
	public List<Salary> findMySalary(int doctorId) {
		logger.debug("findMySalary");
		return salaryDao.findMySalary(doctorId);
	}

}
