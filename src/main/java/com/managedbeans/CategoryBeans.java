package com.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Category;
import com.enums.ModeCategory;
import com.generic.IMetier;

@ManagedBean
@Component
public class CategoryBeans {
	
	@Autowired
	private IMetier<Category> produitMetier;
	ModeCategory mode = ModeCategory.ADD;

	private Category category = new Category();

	private List<Category> list = new ArrayList<Category>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getList() {
		list = produitMetier.getAll();
		return list;
	}
	
	public void updateCategory(int id) {
		category = produitMetier.getOne(id);
		mode = ModeCategory.UPDATE;
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dialog1').show()");
	}

	public void addUpdateCategory() {
		switch (mode) {
		case ADD:
			if (produitMetier.save(category)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Cateory added successfuly");
			} else
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with adding category");
			break;
		case UPDATE:
			if (produitMetier.update(category)) {
				addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Category modified successfuly");
			} else {
				addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Problem with category modification");
			}
			mode = ModeCategory.ADD;
			break;
		}
	}

	public void deleteCategory(Category category) {
		if (produitMetier.delete(category)) {
			getList();
			addMessage(FacesMessage.SEVERITY_INFO, "Confirmed", "Category deleted successfuly");
		} else {
			addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error with deleting category");
		}
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
