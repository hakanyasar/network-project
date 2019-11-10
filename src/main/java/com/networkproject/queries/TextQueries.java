package com.networkproject.queries;

public class TextQueries {

	public static final String findAllTexts = "SELECT t FROM Text t";
	
	public static final String findTextById  = "SELECT t FROM Text t WHERE t.textId = :textId";
	
	public static final String findTextsByRouterId = "SELECT t FROM Text t LEFT JOIN t.router r WHERE r.routerId = :routerId";
	
	public static final String findTextsByUnitId = "SELECT t FROM Text t LEFT JOIN t.unit u WHERE u.unitId = :unitId"; // +
	
	public static final String findTextsByRouterId_UnitId_ProvinceId = "SELECT t FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN t.province p WHERE r.routerId = :routerId AND u.unitId = :unitId AND p.provinceId = :provinceId";
	
	public static final String findTextSubjects = "SELECT t.subject FROM Text t";
	
	public static final String findTextsByUserName = "SELECT t FROM Text t LEFT JOIN t.user u WHERE u.userName = :userName"; // +
	
	public static final String findTextsByRouterBrand = "SELECT t FROM Text t LEFT JOIN t.router r WHERE r.routerBrand = :routerBrand"; // +
	
	public static final String findTextsByRouterModel = "SELECT t FROM Text t LEFT JOIN t.router r WHERE r.routerModel = :routerModel";
	
	public static final String findTextsByProvinceName = "SELECT t FROM Text t LEFT JOIN t.province p WHERE p.provinceName = :provinceName";
	
	public static final String findTextsByUnitName = "SELECT t FROM Text t LEFT JOIN t.unit u WHERE u.unitName = :unitName";
	
	public static final String findTextDetails = "SELECT new com.networkproject.model.TextDetails(t.subject, u.unitName, p.provinceName, r.routerBrand, r.routerModel)"
			+ "FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN u.province p";
	
	public static final String findTextDetailsByTextId = "SELECT new com.networkproject.model.TextDetails(t.subject, u.unitName, p.provinceName, r.routerBrand, r.routerModel)" 
			+ "FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN u.province p WHERE t.textId = :textId";
	
	
	//////////////////////////////////////////////////////////////////////////
	//aciklamalari gör panelindeki comboBox lar için olan sorgular
	/////////////////////////////////////////////////////////////////////////

	public static final String findTextsByUserId = "SELECT t FROM Text t LEFT JOIN t.user u WHERE u.userId = :userId"; // +

	public static final String findTextsByProvinceId = "SELECT t FROM Text t LEFT JOIN t.province p WHERE p.provinceId = :provinceId"; // +

	public static final String findTextsByUserIdAndProvinceId = "SELECT t FROM Text t LEFT JOIN t.user u LEFT JOIN t.province p WHERE u.userId = :userId and p.provinceId = :provinceId";

	public static final String findTextsByUserIdAndProvinceIdAndUnitId = "SELECT t FROM Text t LEFT JOIN t.user u LEFT JOIN t.province p LEFT JOIN t.unit un WHERE u.userId = :userId and p.provinceId = :provinceId and un.unitId = :unitId";

	public static final String findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandName = "SELECT t FROM Text t LEFT JOIN t.user u LEFT JOIN t.province p LEFT JOIN t.unit un LEFT JOIN t.router r WHERE u.userId = :userId and p.provinceId = :provinceId and un.unitId = :unitId and r.routerBrand = :routerBrand";

	public static final String findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName = "SELECT t FROM Text t LEFT JOIN t.user u LEFT JOIN t.province p LEFT JOIN t.unit un LEFT JOIN t.router r WHERE u.userId = :userId and p.provinceId = :provinceId and un.unitId = :unitId and r.routerBrand = :routerBrand and r.routerModel = :routerModel";

	public static final String findTextsByProvinceIdAndUnitId = "SELECT t FROM Text t LEFT JOIN t.province p LEFT JOIN t.unit u WHERE p.provinceId =:provinceId and u.unitId = :unitId";

	public static final String findTextsByProvinceIdAndUnitIdAndRouterBrandName = "SELECT t FROM Text t LEFT JOIN t.province p LEFT JOIN t.unit u LEFT JOIN t.router r WHERE p.provinceId =:provinceId and u.unitId = :unitId and r.routerBrand = :routerBrand";

	public static final String findTextsByProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName = "SELECT t FROM Text t LEFT JOIN t.province p LEFT JOIN t.unit u LEFT JOIN t.router r WHERE p.provinceId =:provinceId and u.unitId = :unitId and r.routerBrand = :routerBrand and r.routerModel = :routerModel";

	public static final String findTextByText = "SELECT t FROM Text t WHERE t.text = :text";
	
	//////////////////////////////////////////////////////////////////////////
	//aciklamalarý gör panelindeki comboBox lar için olan sorgular burada bitiyor
	//////////////////////////////////////////////////////////////////////////
	
	
	
}
