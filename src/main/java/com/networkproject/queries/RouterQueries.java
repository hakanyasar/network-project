package com.networkproject.queries;

public class RouterQueries {

	public static final String findAllRouters = "SELECT r FROM Router r";
	
	public static final String findAllRouterBrands = "Select r.routerBrand FROM Router r";
	
	public static final String findAllRouterModels = "Select r.routerModel FROM Router r";
	
	public static final String findRouterById = "SELECT r FROM Router r WHERE r.routerId = :routerId";
	
	public static final String findRouterByRouterBrandName = "SELECT r FROM Router r WHERE r.routerBrand = :routerBrand";
	
	public static final String findRouterByRouterModelName = "SELECT r FROM Router r WHERE r.routerModel = :routerModel";
	
	public static final String findRouterByRouterBrandAndRouterModel = "SELECT r FROM Router r WHERE r.routerBrand = :routerBrand and r.routerModel = :routerModel";  // +
	
	public static final String findRoutersByUnitId = "SELECT r FROM Router r LEFT JOIN r.unit u WHERE u.unitId = :unitId";
	
	public static final String findRoutersByProvinceId = "SELECT r FROM Router r LEFT JOIN r.province p WHERE p.provinceId = :provinceId";
	
	public static final String findRouterByTextId = "SELECT r FROM Router r LEFT JOIN r.texts t WHERE t.textId = :textId";
	
	public static final String findRouterBrandsByProvinceIdAndUnitId = "SELECT r.routerBrand FROM Router r LEFT JOIN r.province p LEFT JOIN p.units u WHERE p.provinceId = :provinceId and u.unitId = :unitId";
	
	public static final String findRouterModelsByProvinceIdUnitIdRouterId = "SELECT r.routerModel FROM Router r LEFT JOIN r.province p LEFT JOIN p.units u "
			+ "WHERE p.provinceId =:provinceId and u.unitId =:unitId and r.routerId = :routerId";
	
}
