package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Magasin;
import com.generic.IDao;

@Repository
@Transactional
@EnableTransactionManagement
public class MagasinImpl implements IDao<Magasin> {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Magasin> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Magasin").getResultList();
	}

	@Override
	public Magasin getOne(int id) {
		return sessionFactory.getCurrentSession().get(Magasin.class, id);
	}

	@Override
	public boolean save(Magasin obj) {
		try {
			sessionFactory.getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Magasin obj) {
		try {
			sessionFactory.getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Magasin obj) {
		try {
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
