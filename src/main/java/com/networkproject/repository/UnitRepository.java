package com.networkproject.repository;

import java.util.ArrayList;
import java.util.List;

import com.networkproject.model.Unit;

public interface UnitRepository {

	Unit saveUnit(Unit unit);
	
	Unit updateUnit(Unit unit);
	
	Unit deleteUnit(Unit unit);
	
	List<Unit> findAllUnits();
	
	List<String> findAllUnitNames();
	
	Unit findUnitById(int unitId);
	
	ArrayList<String> findUnitNamesByProvinceId(int provinceId);
	
	List<Unit> findUnitsByProvinceId(int provinceId);
	
	Unit findUnitByUnitName(String unitName);
	
}
