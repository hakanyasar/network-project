package com.networkproject.queries;

public class UnitQueries {

	public static final String findAllUnits = "SELECT u FROM Unit u"; 
	
	public static final String findAllUnitNames = "SELECT u.unitName FROM Unit u"; // +
	
	public static final String findUnitById = "SELECT u FROM Unit u WHERE u.unitId = :unitId";
	
	public static final String findUnitByUnitName = "SELECT u FROM Unit u WHERE u.unitName = :unitName"; // +
	
	public static final String findUnitNamesByProvinceId = "SELECT u.unitName FROM Unit u LEFT JOIN u.province p WHERE p.provinceId = :provinceId";
	
	public static final String findUnitsByProvinceId = "SELECT u FROM Unit u LEFT JOI N u.province p WHERE p.provinceId = :provinceId";
	
}
