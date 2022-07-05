package com.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Produit;
import com.generic.IDao;
import com.generic.IMetier;

@Service
public class ProduitImpl implements IMetier<Produit> {

	@Autowired
	private IDao<Produit> dao;
	
	@Override
	public List<Produit> getAll() {
		return dao.getAll();
	}

	@Override
	public Produit getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Produit obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Produit obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Produit obj) {
		return dao.delete(obj);
	}

}
