package com.dashboard.objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value="jsfBeanSaver")
@SessionScoped
public class JSFBeanSaver implements Serializable{
	private List<JSFBackingBean> savedBeans;

	
	public void addBean(String validatedName, String regularname, LocalDate date) {
		JSFBackingBean bean = new JSFBackingBean();
		bean.setValidatedField(validatedName);
		bean.setBeanusField(regularname);
		bean.setAvailDate(date);
		this.savedBeans.add(bean);
	}
	public List<JSFBackingBean> getSavedBeans() {
		if (this.savedBeans==null) {
			this.savedBeans=new ArrayList<>();
		}
		return savedBeans;
	}

	public void setSavedBeans(List<JSFBackingBean> savedBeans) {
		this.savedBeans = savedBeans;
	}
	
	
}
