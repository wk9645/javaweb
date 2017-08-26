package com.wk.bean_to_json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONArray;

public class Test {

	public static void main(String[] args) {
//		beanToJSON();
		
//		ArrayToJSON();
		
//		mapToJSON();
		
		beanAndArrToJSON();
	}
	
	
	/*
	 * 1��java����ת��Ϊjson�ı�
	 */
	public static void beanToJSON(){
		
		City city= new City(1, "����");
		
		//ʹ��JSONArray����ת��
		JSONArray j = JSONArray.fromObject(city);
		System.out.println(j.toString());
		
		//������ݣ�[{"cityId":1,"cityName":"����"}]
	}
	
	/*
	 * 2�����϶���ת��Ϊjson�ı�
	 */
	public static void ArrayToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "����"));
		aList.add(new City(2, "����"));
		
		//ʹ��JSONArray����ת��
		JSONArray j = JSONArray.fromObject(aList);
		System.out.println(j.toString());
		
		//������ݣ�[{"cityId":1,"cityName":"����"},{"cityId":2,"cityName":"����"}]
	}
	
	/*
	 * 3��map����ת��Ϊjson�ı�
	 */
	public static void mapToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "����"));
		aList.add(new City(2, "����"));
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		map.put("length", aList.size());
		map.put("content", aList);
		//ʹ��JSONArray����ת��
		JSONArray j = JSONArray.fromObject(map);
		System.out.println(j.toString());
		
		//������ݣ�[{"content":[{"cityId":1,"cityName":"����"},{"cityId":2,"cityName":"����"}],"length":2}]
	}
	
	
	/*
	 * 4��java�����������ת��Ϊjson�ı�
	 */
	public static void beanAndArrToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "����"));
		aList.add(new City(2, "����"));
		
		Province province = new Province(1, "����ʡ", aList);
		
		//ʹ��JSONArray����ת��
		JSONArray j = JSONArray.fromObject(province);
		System.out.println(j.toString());
		
		//������ݣ�[{"proId":1,"proName":"����ʡ","aList":[{"cityId":1,"cityName":"����"},{"cityId":2,"cityName":"����"}]}]
	}
	
}
