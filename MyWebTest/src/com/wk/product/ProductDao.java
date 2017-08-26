package com.wk.product;

import java.util.ArrayList;
import java.util.List;


/*
 * 该类存储对Product对象的CRUD操作
 * 
 */
public class ProductDao {

	private static List<Product> products = new ArrayList<Product>();
	
	
	//初始化商品数据
	
	static{
		for(int i=1;i<=10;i++){
			products.add(new Product(""+i,"笔记本"+i,"华硕"+i,40.0+i));
		}
	}
	
	/*
	 * 提供查询所有商品的方法
	 * 
	 */
	
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}
	
	
	/*
	 * 根据编号查询商品
	 * 
	 */
	
	public Product findById(String id){
		
		for (Product item : products) {
			if(item.getId().equals(id))
				return item;
		}
		return null;
		
	}
	
	
}
