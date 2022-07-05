package com.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Magasin;
import com.generic.IDao;
import com.generic.IMetier;

@Service
public class MagasinImpl implements IMetier<Magasin> {

	@Autowired
	private IDao<Magasin> dao;
	
	@Override
	public List<Magasin> getAll() {
		return dao.getAll();
	}

	@Override
	public Magasin getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Magasin obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Magasin obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Magasin obj) {
		return dao.delete(obj);
	}

}
