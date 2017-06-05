package com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Adress;

import com.dao.AdressDao;

@Service
@Transactional
public class AdressService {
	
	@Autowired
	private AdressDao ad;

	public AdressService() {
		
	}
	public void createAdress(Adress adress){
		ad.createAdress(adress);
	}
	public List<Adress> listAdresses(){
		return ad.listAdresses();
	}
	
	public Adress getAdressbyId(long id){
		return ad.getAdressbyId(id);
	}

}
