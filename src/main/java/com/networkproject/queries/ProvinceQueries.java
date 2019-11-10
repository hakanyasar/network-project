package com.networkproject.queries;

public class ProvinceQueries {

	public static final String findAllProvinces = "SELECT p FROM Province p";
	
	public static final String findAllProvinceNames = "SELECT p.provinceName FROM Province p"; // +
	
	public static final String findProvinceByProvinceName = "SELECT p FROM Province p WHERE p.provinceName = :provinceName"; // +
	
	public static final String findProvinceById = "SELECT p FROM Province p WHERE p.provinceId = :provinceId";
	
}
