package com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Produit_magasin {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produit")
	int id_produit ;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_magasin")
	int id_magasin ;
	@JoinColumn
	int Qte;
}
