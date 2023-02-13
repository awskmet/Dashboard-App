package com.dashboard.objects;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value="test")
@RequestScoped
public class JSFBackingBean implements Serializable{
private String beanusField;
private String deenusField;

public String getBeanusField() {
	return beanusField;
}
public void setBeanusField(String beanusField) {
	this.beanusField = beanusField;
}
public String getDeenusField() {
	return deenusField;
}
public void setDeenusField(String deenusField) {
	this.deenusField = deenusField;
}
}
