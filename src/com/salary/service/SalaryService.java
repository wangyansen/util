package com.salary.service;

import java.util.List;

import entity.Salary;

public interface SalaryService {
	List<Salary> findMySalary(int doctorId);

}
