package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Adress;
@Repository
public class AdressDao {
@Autowired
private SessionFactory sf;

	public AdressDao() {
		
	}
	
	private Session getCurrentSession(){
		return sf.getCurrentSession();
	}
	
	public void createAdress(Adress adress){
		
		getCurrentSession().save(adress);
	}
	
	public List<Adress> listAdresses(){
		Session session=this.getCurrentSession();
		String hql="from Adress ";
		Query query=session.createQuery(hql);
		return (List<Adress>) query.list();	
	}
	
	public Adress getAdressbyId(long id){
		Session session=this.getCurrentSession();
		String hql="from Adress a where a.id=:id ";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		Adress adress=(Adress)query.list().get(0);
		return adress;
	}

}
