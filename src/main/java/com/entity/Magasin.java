package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="magasin")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Magasin {

	@Id
	@GeneratedValue
	@Column(name="id_magasin")
	 int id_magasin;  
	 String nom;
	 String adresse; 
	 
	 @OneToMany(mappedBy = "magasin")
	 private List<Produit_magasin> produit_magasin;
	
}
