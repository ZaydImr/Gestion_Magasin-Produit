package com.managedbeans;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Magasin;
import com.enums.ModeMagasin;
import com.generic.IMetier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@Component
public class MagasinBeans {

	@Autowired
	private IMetier<Magasin> magasinMetier;
	ModeMagasin mode = ModeMagasin.ADD;

	private Magasin magasin = new Magasin();

	private List<Magasin> list = new ArrayList<Magasin>();

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public List<Magasin> getList() {
		list = magasinMetier.getAll();
		return list;
	}
	
	public void updateMagasin(int id) {
		magasin = magasinMetier.getOne(id);
		mode = ModeMagasin.UPDATE;
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dialog1').show()");
	}

	public void addUpdateMagasin() {
		switch (mode) {
		case ADD:
			if (magasinMetier.save(magasin)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Magasin added successfuly");
			} else
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with adding magasin");
			break;
		case UPDATE:
			if (magasinMetier.update(magasin)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Magasin modified successfuly");
			} else {
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with magasin modification");
			}
			mode = ModeMagasin.ADD;
			break;
		}
	}

	public void deleteMagasin(Magasin magasin) {
		if (magasinMetier.delete(magasin)) {
			getList();
			addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Magasin deleted successfuly");
		} else {
			addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error with deleting magasin");
		}
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}