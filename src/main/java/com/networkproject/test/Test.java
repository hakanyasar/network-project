package com.networkproject.test;

import java.awt.EventQueue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.networkproject.model.Province;
import com.networkproject.model.Router;
import com.networkproject.model.Text;
import com.networkproject.model.TextDetails;
import com.networkproject.model.Unit;
import com.networkproject.repository.ProvinceRepository;
import com.networkproject.repository.RouterRepository;
import com.networkproject.repository.TextRepository;
import com.networkproject.repository.UnitRepository;
import com.networkproject.repositoryImpl.ProvinceRepositoryImpl;
import com.networkproject.repositoryImpl.RouterRepositoryImpl;
import com.networkproject.repositoryImpl.TextRepositoryImpl;
import com.networkproject.repositoryImpl.UnitRepositoryImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

public class Test {

	private static TextRepository textRepository = new TextRepositoryImpl(); 
	private static RouterRepository routerRepository = new RouterRepositoryImpl();
	private static ProvinceRepository provinceRepository = new ProvinceRepositoryImpl();
	private static UnitRepository unitRepository = new UnitRepositoryImpl();
	
	public static void main(String[] args) {
		
		//insertData();
		
		
		/*
		//findAllText = "SELECT t FROM Text t";
		 
		List<Text> texts = textRepository.findAllText();
		
		for (Text text : texts) {
			
			System.out.println(text);
		}
		*/
		
		
		/*
		 * findTextById = "SELECT t FROM Text t WHERE t.textId = :textId";
		 * 
		Text text = textRepository.findTextById(2);
		System.out.println(text);
		*/
		
		
		/*
		findTextDetailsByTextId = "SELECT new com.networkproject.model.TextDetails(t.subject, u.unitName, p.provinceName, r.routerBrand, r.routerModel)" 
		+ "FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN u.province p WHERE t.textId = :textId";
		
		TextDetails textDetails = textRepository.findTextDetailsByTextId(1);
		System.out.println(textDetails);
		*/
		
		/*
		findTextsByRouterId = "SELECT t FROM Text t LEFT JOIN t.router r WHERE r.routerId = :routerId";
		
		List<Text> texts = textRepository.findTextsByRouterId(1);
		
		for (Text text : texts) {
			System.out.println(texts);
		}
		*/
		
		/*
		findTextsByUnitId = "SELECT t FROM Text t LEFT JOIN t.unit u WHERE u.unitId = :unitId";
		
		List<Text> texts = textRepository.findTextsByUnitId(2);
		for (Text text : texts) {
			System.out.println(texts);
		}
		*/
		
		/*
		findTextsByProvinceId = "SELECT t FROM Text t LEFT JOIN t.province p WHERE p.provinceId = :provinceId";
		
		List<Text> texts = textRepository.findTextsByProvinceId(2);
		for (Text text : texts) {
			System.out.println(texts);
		}
		*/
		
		
		/*
		findTextsByRouterId_UnitId_ProvinceId = "SELECT t FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN t.province p 
													WHERE r.routerId = :routerId AND u.unitId = :unitId AND p.provinceId = :provinceId";
		
		List<Text> texts = textRepository.findTextsByRouterId_UnitId_ProvinceId(1, 1, 1);
		for (Text text : texts) {
			System.out.println(texts);
		}
		*/
		
		/*
		findTextDetails = "SELECT new com.networkproject.model.TextDetails(t.subject, u.unitName, p.provinceName, r.routerBrand, r.routerModel)"
				+ "FROM Text t LEFT JOIN t.router r LEFT JOIN t.unit u LEFT JOIN u.province p";
		
		List<TextDetails> textDetails = textRepository.findTextDetails();
		for (TextDetails textDetails2 : textDetails) {
			System.out.println(textDetails2);
		}
		*/
		
		/*
		findTextSubjects = "SELECT t.subject FROM Text t";
		List<String> subjectes = textRepository.findTextSubjects();
		
		for (String string : subjectes) {
			System.out.println(string);
		}
		*/
		
		/*
		findAllProvinces = "SELECT p FROM Province p";
		
		List<Province> provinces = provinceRepository.findAllProvinces();
		for (Province province : provinces) {
			System.out.println(province);
		}
		*/
		
		
		/*
		findAllProvinceNames = "SELECT p.provinceName FROM Province p";
		
		List<String> provinceNames = provinceRepository.findAllProvinceNames();
		for (String string : provinceNames) {
			System.out.println(string);
		}
		*/
		
		
		/*
		findProvinceById = "SELECT p FROM Province p WHERE p.provinceId = :provinceId";
		Province province = provinceRepository.findProvinceById(2);
		System.out.println(province);
		*/
		
		/*
		List<Router> routers = routerRepository.findAllRouters();
		for (Router router : routers) {
			System.out.println(router);
		}
		*/
		
		/*
		findRouterById = "SELECT r FROM Router r WHERE r.routerId = :routerId";
		
		Router router = routerRepository.findRouterById(2);
		System.out.println(router);
		*/
		
		/*
		findRoutersByUnitId = "SELECT r FROM Router r LEFT JOIN r.unit u WHERE u.unitId = :unitId";
		
		List<Router> routers = routerRepository.findRoutersByUnitId(1);
		for (Router router : routers) {
			System.out.println(router);
		}
		*/
		
		
		/*
		findRoutersByProvinceId = "SELECT r FROM Router r LEFT JOIN r.province p WHERE p.provinceId = :provinceId";
		
		List<Router> routers = routerRepository.findRoutersByProvinceId(2);
		for (Router router : routers) {
			System.out.println(router);
		}
		*/
		
		/*
		findRouterByTextId = "SELECT r FROM Router r LEFT JOIN r.texts t WHERE t.textId = :textId";
		
		Router router = routerRepository.findRouterByTextId(2);
		System.out.println(router);
		*/
		
		/*
		findAllUnits = "SELECT u FROM Unit u";
		List<Unit> units = unitRepository.findAllUnits();
		
		for (Unit unit : units) {
			System.out.println(unit);
		}
		*/
		
		
		/*
		findAllUnitNames = "SELECT u.unitName FROM Unit u";
		
		List<String> unitNames = unitRepository.findAllUnitNames();
		for (String string : unitNames) {
			System.out.println(string);
		}
		*/
		
		/*
		findUnitById = "SELECT u FROM Unit u WHERE u.unitId = :unitId";
		
		Unit unit = unitRepository.findUnitById(1);
		System.out.println(unit);
		*/
		
		
		/*
		findUnitsByProvinceName = "SELECT u FROM Unit u LEFT JOIN u.province p WHERE p.provinceName = :provinceName";
		
		List<Unit> units = unitRepository.findUnitsByProvinceName("Eskisehir");
		for (Unit unit : units) {
			System.out.println(unit);
		}
		*/
		
		
		/*
		findUnitsByProvinceId = "SELECT u FROM Unit u LEFT JOIN u.province p WHERE p.provinceId = :provinceId";
		
		List<Unit> units = unitRepository.findUnitsByProvinceId(2);
		for (Unit unit : units) {
			System.out.println(unit);
		}
		*/
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.getFrmNetwopro().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getfrmNetwoPro().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow window = new UserWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}
	
	public static void insertData() {
		/*
		Province province1 = new Province("Istanbul");
		Province province2 = new Province("Eskisehir");
		
		Unit unit1 = new Unit("istanbul mahkemesi", province1);
		Unit unit2 = new Unit("ankara mahkemesi", province2);
		
		Router router1 = new Router("huawei", "AS17GH", new Date(), null, province1, unit1);
		Router router2 = new Router("samsung", "SAM569RTR", new Date(), null, province2, unit2);
		
		Text text1 = new Text("konu basligi buraya", "hebele hubele kem kum", new Date(), null, unit1, router1, province1);
		Text text2 = new Text("yine konu basligi buraya", "hebele hubele laplup hyhyhyhy", new Date(), null, unit2, router2, province2);
		
		
		provinceRepository.saveProvince(province1);
		provinceRepository.saveProvince(province2);
		
		unitRepository.saveUnit(unit1);
		unitRepository.saveUnit(unit2);
		
		routerRepository.saveRouter(router1);
		routerRepository.saveRouter(router2);
		
		textRepository.saveText(text1);
		textRepository.saveText(text2);		
		
		*/
	}
	
}
