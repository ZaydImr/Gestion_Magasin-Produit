package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Magasin {

	@Id
	@GeneratedValue
	@Column(name="id_magasin")
	 int id_magasin;  
	 String nom;
	 String adresse; 
}
