package com.networkproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Router {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int routerId;
	
	private String routerBrand;
	
	private String routerModel;
	
	@OneToMany(mappedBy = "router")
	private List<Text> texts;
	
	@ManyToOne
	@JoinColumn(name = "unitId")
	private Unit unit; 
	
	@ManyToOne
	@JoinColumn(name = "provinceId")
	private Province province;
	
	public Router() {

	}

	public Router(String routerBrand, String routerModel, Province province, Unit unit) {
		this.routerBrand = routerBrand;
		this.routerModel = routerModel;
		this.province = province;
		this.unit = unit;
		
	}

	public int getRouterId() {
		return routerId;
	}

	public void setRouterId(int routerId) {
		this.routerId = routerId;
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

	public List<Text> getTexts() {
		return texts;
	}

	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Router [routerId=" + routerId + ", routerBrand=" + routerBrand + ", routerModel=" + routerModel + "]";
	}

}
