package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ClinicDAO;
import com.model.Clinic;

@Service
@Transactional
public class ClinicService {

	@Autowired
	private ClinicDAO clinicDao;
	
	public void addClinic(Clinic clinic) {
		clinicDao.addClinic(clinic);
	}
	
	public Clinic getClinic(int id) {
		return clinicDao.getClinic(id);
	}
	
	public List<Clinic> getClinics() {
		return clinicDao.getClinics();
	}
	
	public void storeAllClinics(List<Clinic> clinics) {
		clinicDao.storeAllClinics(clinics);
	}
}
