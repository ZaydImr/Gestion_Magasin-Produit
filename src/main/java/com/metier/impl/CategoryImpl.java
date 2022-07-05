package com.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.generic.IDao;
import com.generic.IMetier;

@Service
public class CategoryImpl implements IMetier<Category> {

	@Autowired
	private IDao<Category> dao;
	
	@Override
	public List<Category> getAll() {
		return dao.getAll();
	}

	@Override
	public Category getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Category obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Category obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Category obj) {
		return dao.delete(obj);
	}

}
