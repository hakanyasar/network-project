package com.networkproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Province implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int provinceId;
	
	private String provinceName;
	
	@OneToMany(mappedBy = "province")
	private List<Unit> units;
	
	@OneToMany(mappedBy = "province")
	private List<Router> routers;
	
	public Province() {
		
	}

	public Province(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	

	public List<Router> getRouters() {
		return routers;
	}

	public void setRouters(List<Router> routers) {
		this.routers = routers;
	}

	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName=" + provinceName + "]";
	}


}
