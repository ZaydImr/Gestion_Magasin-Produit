package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Magasin;
import com.entity.Produit;
import com.generic.IDao;

public class ProduitImpl implements IDao<Produit> {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Produit> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Produit").getResultList();
	}

	@Override
	public Produit getOne(int id) {
		return sessionFactory.getCurrentSession().get(Produit.class, id);
	}

	@Override
	public boolean save(Produit obj) {
		try {
			sessionFactory.getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Produit obj) {
		try {
			sessionFactory.getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Produit obj) {
		try {
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
