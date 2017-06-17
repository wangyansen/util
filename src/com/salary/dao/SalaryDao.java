package com.salary.dao;

import java.util.List;

import entity.Salary;

public interface SalaryDao {
	List<Salary> findMySalary(int doctorId);

}
