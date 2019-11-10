package com.networkproject.repository;

import java.util.ArrayList;
import java.util.List;

import com.networkproject.model.Router;

public interface RouterRepository {

	Router saveRouter(Router router);
	
	Router updateRouter(Router router);
	
	Router deleteRouter(Router router);
	
	List<Router> findAllRouters();
	
	List<String> findAllRouterBrands();
	
	ArrayList<String> findAllRouterModels();
	
	Router findRouterById(int routerId);
	
	List<Router> findRoutersByUnitId(int unitId);
	
	List<Router> findRoutersByProvinceId(int provinceId);
	
	Router findRouterByTextId(int textId);
	
	Router findRouterByRouterBrandAndRouterModel(String routerBrand, String routerModel);
	
	ArrayList<String> findRouterBrandsByProvinceIdAndUnitId(int provinceId, int unitId);
	
	Router findRouterByRouterBrandName(String routerBrand);
	
	ArrayList<String> findRouterModelsByProvinceIdUnitIdRouterId(int provinceId, int unitId, int routerId);
}
