package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Category;
import com.generic.IDao;

@Repository
@Transactional
@EnableTransactionManagement
public class CategoryImpl implements IDao<Category> {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
	}

	@Override
	public Category getOne(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean save(Category obj) {
		try {
			sessionFactory.getCurrentSession().save(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Category obj) {
		try {
			sessionFactory.getCurrentSession().update(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Category obj) {
		try {
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
