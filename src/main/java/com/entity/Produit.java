package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table
@Entity
public class Produit {
	@Id
	@GeneratedValue
	@Column(name="id_produit")
	int id_produit ;
	@Column
	String  titre;
	@Column
	String  description ;
	@Column
	float  prix ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category")
	   private Category category ;
}
