package com.drug.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.drug.dao.DrugDao;
import com.drug.service.DrugService;

import entity.Drug;
@Service
public class DrugServiceImpl implements DrugService {
	private static Logger logger =Logger.getLogger(DrugServiceImpl.class);
	@Resource(name="drugDao")
	  private DrugDao drugDao;
	
	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}

	@Override
	public List<Drug> findAllDrug() {
		List<Drug>list=drugDao.findAllDrug();
		logger.debug(list.size());
		return list;
	}

}
