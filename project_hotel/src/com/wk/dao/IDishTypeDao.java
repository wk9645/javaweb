package com.wk.dao;

import java.util.List;

import com.wk.entity.DishType;

public interface IDishTypeDao {
	
	/**
	 * 添加菜系
	 * @param dishType  菜系对象
	 */
	void save(DishType dishType);
	
	/**
	 * 更新菜系
	 * @param dishType  菜系对象
	 */
	void update(DishType dishType);
	
	/**
	 * 删除菜系
	 * @param id   菜系id
	 */
	void delete(int id);
	
	/**
	 * 查找全部菜系
	 * @return		list集合
	 */
	List<DishType> getAll();
	
	/**
	 * 根据菜系名称查找
	 * @param typeName	菜系名
	 * @return		
	 */
	List<DishType> getByName(String typeName);
	
	/**
	 * 根据主键查询
	 * @param id	主键
	 * @return		菜系对象
	 */
	DishType findById(int id);
	
	
	
}
