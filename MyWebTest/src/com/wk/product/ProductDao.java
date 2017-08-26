package com.wk.product;

import java.util.ArrayList;
import java.util.List;


/*
 * ����洢��Product�����CRUD����
 * 
 */
public class ProductDao {

	private static List<Product> products = new ArrayList<Product>();
	
	
	//��ʼ����Ʒ����
	
	static{
		for(int i=1;i<=10;i++){
			products.add(new Product(""+i,"�ʼǱ�"+i,"��˶"+i,40.0+i));
		}
	}
	
	/*
	 * �ṩ��ѯ������Ʒ�ķ���
	 * 
	 */
	
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}
	
	
	/*
	 * ���ݱ�Ų�ѯ��Ʒ
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
