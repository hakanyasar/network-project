package com.networkproject.repository;

import java.util.List;

import com.networkproject.model.Province;

public interface ProvinceRepository {

	Province saveProvince(Province province);
	
	Province updateProvince(Province province);
	
	Province deleteProvince(Province province);
	
	List<Province> findAllProvinces();
	
	List<String> findAllProvinceNames();
	
	Province findProvinceById(int provinceId);
	
	Province findProvinceByProvinceName(String provinceName);
}
