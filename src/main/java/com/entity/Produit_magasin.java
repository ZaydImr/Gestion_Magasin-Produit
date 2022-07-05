package com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="produit_magasin")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Produit_magasin {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_magasin")
	private Magasin magasin;
	
	private int qte;
	
}
