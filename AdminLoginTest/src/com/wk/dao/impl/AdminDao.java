package com.wk.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.wk.dao.IAdminDao;
import com.wk.entity.Admin;
import com.wk.util.JdbcUtil;

/**
 * 2. 数据访问层接口的实现类
 * (引入DbUtils组件简化jdbc操作)
 * @author Jie.Yuan
 *
 */
public class AdminDao implements IAdminDao {

	private Connection con;
	private QueryRunner qr = new QueryRunner();

	@Override
	public Admin findByNameAndPwd(Admin admin) {
		String sql = "select * from admin where userName=? and pwd=?";
		try{
			con = JdbcUtil.getConnection();
			Admin ad = qr.query(con, sql, 
					new BeanHandler<Admin>(Admin.class), 
					admin.getName(),
					admin.getPassword());
			return ad;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con, null, null);
		}
	}

	@Override
	public void save(Admin admin) {
		String sql = "INSERT INTO admin(userName,pwd) VALUES(?,?);";
		try {
			con = JdbcUtil.getConnection();
			// 使用DbUtils组件的方法更新
			qr.update(con, sql, admin.getUserName(),admin.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, null, null);
		}
		
	}

	@Override
	public boolean userExists(String name) {
		String sql = "select id from admin where userName=?";
		try {
			con = JdbcUtil.getConnection();
			Integer in = qr.query(con, sql, new ScalarHandler<Integer>(), name);
			if (in != null){
				return true;
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, null, null);
		}
	}

}
