package com.wk.service.impl;

import java.util.List;

import com.wk.dao.IDishTypeDao;
import com.wk.entity.DishType;
import com.wk.factory.BeanFactory;
import com.wk.service.IDishTypeService;


/**
 * 业务逻辑层接口实现
 * @author asus
 *
 */
public class DishTypeService implements IDishTypeService{

	private IDishTypeDao dishTypeDao = BeanFactory.getInstance("dishTypeDao", IDishTypeDao.class);
	
	@Override
	public void save(DishType dishType) {
		try {
			dishTypeDao.save(dishType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(DishType dishType) {
		try {
			dishTypeDao.update(dishType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			dishTypeDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DishType> getAll() {
		try {
			return dishTypeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<DishType> getByName(String typeName) {
		try {
			return dishTypeDao.getByName(typeName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DishType findById(int id) {
		try {
			return dishTypeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
