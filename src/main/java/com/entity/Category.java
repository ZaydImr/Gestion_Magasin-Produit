package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="id_category")
	int id_category ;
	@Column
	String nom_category;
	@OneToMany(mappedBy="id_category",fetch=FetchType.LAZY)
	private List<Produit> produits;
}
