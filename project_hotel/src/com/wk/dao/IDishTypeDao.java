package com.wk.dao;

import java.util.List;

import com.wk.entity.DishType;

public interface IDishTypeDao {
	
	/**
	 * ��Ӳ�ϵ
	 * @param dishType  ��ϵ����
	 */
	void save(DishType dishType);
	
	/**
	 * ���²�ϵ
	 * @param dishType  ��ϵ����
	 */
	void update(DishType dishType);
	
	/**
	 * ɾ����ϵ
	 * @param id   ��ϵid
	 */
	void delete(int id);
	
	/**
	 * ����ȫ����ϵ
	 * @return		list����
	 */
	List<DishType> getAll();
	
	/**
	 * ���ݲ�ϵ���Ʋ���
	 * @param typeName	��ϵ��
	 * @return		
	 */
	List<DishType> getByName(String typeName);
	
	/**
	 * ����������ѯ
	 * @param id	����
	 * @return		��ϵ����
	 */
	DishType findById(int id);
	
	
	
}
