package com.dashboard.objects;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value="jsfBean")
@RequestScoped
public class JSFBackingBean implements Serializable{
private String beanusField;
public String getValidatedField() {
	return validatedField;
}
public void setValidatedField(String validatedField) {
	this.validatedField = validatedField;
}
private String validatedField;
private String deenusField;
private LocalDate availDate;

public LocalDate getAvailDate() {
	return availDate;
}
public void setAvailDate(LocalDate availDate) {
	this.availDate = availDate;
}
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
