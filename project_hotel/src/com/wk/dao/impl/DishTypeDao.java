package com.wk.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wk.dao.IDishTypeDao;
import com.wk.entity.DishType;
import com.wk.utils.JdbcUtil;

public class DishTypeDao implements IDishTypeDao {

	@Override
	public void save(DishType dishType) {
		String sql = "INSERT INTO dishtype(typeName) VALUES (?)";
		try {
			JdbcUtil.getQueryRunner().update(sql,dishType.getTypeName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(DishType dishType) {
		String sql = "UPDATE dishType SET typeName=? WHERE id=?";		
		try {
			JdbcUtil.getQueryRunner().update(sql,dishType.getTypeName(),dishType.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM dishtype WHERE id=?";		
		try {
			JdbcUtil.getQueryRunner().update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DishType> getAll() {
		String sql = "SELECT *FROM dishType";
		try {
			return JdbcUtil.getQueryRunner().query(sql, new BeanListHandler<DishType>(DishType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public List<DishType> getByName(String typeName) {
		String sql = "SELECT *FROM dishtype WHERE typeName LIKE ?";
		try {
			return JdbcUtil.getQueryRunner().query(sql, new BeanListHandler<DishType>(DishType.class),"%"+ typeName + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DishType findById(int id) {
		String sql = "SELECT *FROM dishtype WHERE id=?";
		try {
			return JdbcUtil.getQueryRunner().query(sql, new BeanHandler<DishType>(DishType.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
