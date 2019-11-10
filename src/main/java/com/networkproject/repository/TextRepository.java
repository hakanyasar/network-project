package com.networkproject.repository;

import java.util.List;

import com.networkproject.model.Text;
import com.networkproject.model.TextDetails;

public interface TextRepository {

	Text saveText(Text text);
	
	Text updateText(Text text);
	
	Text deleteText(Text text);
	
	List<Text> findAllText();
	
	Text findTextById(int textId);
	
	TextDetails findTextDetailsByTextId(int textId);
	
	List<Text> findTextsByRouterId(int routerId);
	
	List<Text> findTextsByUnitId(int unitId);
	
	List<Text> findTextsByRouterId_UnitId_ProvinceId(int routerId, int unitId, int provinceId);
	
	List<TextDetails> findTextDetails();
	
	List<String> findTextSubjects();
	
	List<Text> findTextsByUserName(String userName);
	
	List<Text> findTextsByRouterBrand(String routerBrand);
	
	List<Text> findTextsByRouterModel(String routerModel);
	
	List<Text> findTextsByProvinceName(String provinceName);
	
	List<Text> findTextsByUnitName(String unitName);
	
	//////////////////////////////////////////////////////////////////////////
	//asag�daki k�s�m, aciklamalari g�r panelindeki comboBox lar i�in olan sorgular
	/////////////////////////////////////////////////////////////////////////
	
	List<Text> findTextsByUserId(int userId);
	
	List<Text> findTextsByProvinceId(int provinceId);
	
	List<Text> findTextsByUserIdAndProvinceId(int userId, int provinceId);
	
	List<Text> findTextsByUserIdAndProvinceIdAndUnitId(int userId, int provinceId, int unitId);
	
	List<Text> findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandName(int userId, int provinceId, int unitId, String routerBrand);
	
	List<Text> findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(int userId, int provinceId, int unitId, String routerBrand, String routerModel);
	
	List<Text> findTextsByProvinceIdAndUnitId(int provinceId, int unitId);
	
	List<Text> findTextsByProvinceIdAndUnitIdAndRouterBrandName(int provinceId, int unitId, String routerBrand);
	
	List<Text> findTextsByProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(int provinceId, int unitId, String routerBrand, String routerModel);
	
	Text findTextByText(String text);
	
	//////////////////////////////////////////////////////////////////////////
	//aciklamalari g�r panelindeki comboBox lar i�in olan sorgular burada bitiyor
	/////////////////////////////////////////////////////////////////////////
	
}
