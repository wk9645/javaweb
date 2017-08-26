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
	 * 1、java对象转化为json文本
	 */
	public static void beanToJSON(){
		
		City city= new City(1, "西安");
		
		//使用JSONArray进行转换
		JSONArray j = JSONArray.fromObject(city);
		System.out.println(j.toString());
		
		//输出内容：[{"cityId":1,"cityName":"西安"}]
	}
	
	/*
	 * 2、集合对象转化为json文本
	 */
	public static void ArrayToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "西安"));
		aList.add(new City(2, "咸阳"));
		
		//使用JSONArray进行转换
		JSONArray j = JSONArray.fromObject(aList);
		System.out.println(j.toString());
		
		//输出内容：[{"cityId":1,"cityName":"西安"},{"cityId":2,"cityName":"咸阳"}]
	}
	
	/*
	 * 3、map对象转化为json文本
	 */
	public static void mapToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "西安"));
		aList.add(new City(2, "咸阳"));
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		map.put("length", aList.size());
		map.put("content", aList);
		//使用JSONArray进行转换
		JSONArray j = JSONArray.fromObject(map);
		System.out.println(j.toString());
		
		//输出内容：[{"content":[{"cityId":1,"cityName":"西安"},{"cityId":2,"cityName":"咸阳"}],"length":2}]
	}
	
	
	/*
	 * 4、java对象包含数组转化为json文本
	 */
	public static void beanAndArrToJSON(){
		
		ArrayList<City> aList = new ArrayList<City>();
		aList.add(new City(1, "西安"));
		aList.add(new City(2, "咸阳"));
		
		Province province = new Province(1, "陕西省", aList);
		
		//使用JSONArray进行转换
		JSONArray j = JSONArray.fromObject(province);
		System.out.println(j.toString());
		
		//输出内容：[{"proId":1,"proName":"陕西省","aList":[{"cityId":1,"cityName":"西安"},{"cityId":2,"cityName":"咸阳"}]}]
	}
	
}
