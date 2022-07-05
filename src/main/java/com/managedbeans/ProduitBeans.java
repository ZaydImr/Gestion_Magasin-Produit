package com.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Produit;
import com.enums.ModeProduit;
import com.generic.IMetier;

@ManagedBean
@Component
public class ProduitBeans {

	@Autowired
	private IMetier<Produit> produitMetier;
	ModeProduit mode = ModeProduit.ADD;

	private Produit produit = new Produit();

	private List<Produit> list = new ArrayList<Produit>();

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getList() {
		list = produitMetier.getAll();
		return list;
	}
	
	public void updateProduit(int id) {
		produit = produitMetier.getOne(id);
		mode = ModeProduit.UPDATE;
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dialog1').show()");
	}

	public void addUpdateProduit() {
		switch (mode) {
		case ADD:
			if (produitMetier.save(produit)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Product added successfuly");
			} else
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with adding product");
			break;
		case UPDATE:
			if (produitMetier.update(produit)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Product modified successfuly");
			} else {
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with product modification");
			}
			mode = ModeProduit.ADD;
			break;
		}
	}

	public void deleteProduit(Produit produit) {
		if (produitMetier.delete(produit)) {
			getList();
			addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Product deleted successfuly");
		} else {
			addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error with deleting Product");
		}
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
