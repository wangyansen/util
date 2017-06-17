package com.medicalAppliance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.medicalAppliance.dao.MedicalApplianceDao;
import com.medicalAppliance.service.MedicalApplianceService;

import entity.MedicalAppliance;
@Service
public class MedicalApplianceServiceImpl implements MedicalApplianceService {
	private static Logger logger =Logger.getLogger(MedicalApplianceServiceImpl.class);
	@Resource(name="medicalApplianceDao")
	  private MedicalApplianceDao medicalApplianceDao;
	
	public void setMedicalApplianceDao(MedicalApplianceDao medicalApplianceDao) {
		this.medicalApplianceDao = medicalApplianceDao;
	}

	@Override
	public List<MedicalAppliance> findAllMedicalAppliance() {
		List<MedicalAppliance>list=medicalApplianceDao.findAllMedicalAppliance();
		logger.debug(list.size());
		return list;
	}

}
