package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Clinic;

@Repository
public class ClinicDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Clinic> getClinics() {
		String hql = "from Clinic";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<Clinic>)query.list();
	}

	public void addClinic(Clinic clinic) {
		sessionFactory.getCurrentSession().save(clinic);
	}
	
	public Clinic getClinic(int id) {
		String hql = "from Clinic clinic where clinic.id = :clinicId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("clinicId", id);
		List<Clinic> clinics = (List<Clinic>)query.list();
		if ( clinics.size() == 1 ) {
			return clinics.get(0);
		} else {
			return null;
		}
	}
	
	public void storeAllClinics(List<Clinic> clinics) {
		for ( Clinic clinic: clinics) {
			addClinic(clinic);
		}
	}
}
