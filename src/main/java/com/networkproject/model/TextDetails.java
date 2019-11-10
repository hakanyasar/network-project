package com.networkproject.model;

public class TextDetails {

	private String textSubject;
	
	private String unitName;
	
	private String provinceName;
	
	private String routerBrand;
	
	private String routerModel;
	
	public TextDetails() {

	}

	public TextDetails(String textSubject, String unitName, String provinceName, String routerBrand, String routerModel) {
		super();
		this.textSubject = textSubject;
		this.unitName = unitName;
		this.provinceName = provinceName;
		this.routerBrand = routerBrand;
		this.routerModel = routerModel;
	}

	public String getTextSubject() {
		return textSubject;
	}

	public void setTextSubject(String textSubject) {
		this.textSubject = textSubject;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getRouterBrand() {
		return routerBrand;
	}

	public void setRouterBrand(String routerBrand) {
		this.routerBrand = routerBrand;
	}

	public String getRouterModel() {
		return routerModel;
	}

	public void setRouterModel(String routerModel) {
		this.routerModel = routerModel;
	}

	@Override
	public String toString() {
		return "TextDetail [textSubject=" + textSubject + ", unitName=" + unitName + ", provinceName=" + provinceName
				+ ", routerBrand=" + routerBrand + ", routerModel=" + routerModel + "]";
	}

}
