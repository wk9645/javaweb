package com.wk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.wk.dao.IAdminDao;
import com.wk.entity.Admin;
import com.wk.utils.JdbcUtil;

public class AdminDao extends BaseDao implements IAdminDao{

	
	@Override
	public void save(Admin admin) {
		
		String sql = "INSERT INTO admin (userName,PASSWORD) VALUES(?,?)";
		Object[] paramsValue = {admin.getUserName(),admin.getPassword()};
		super.update(sql, paramsValue);
		
	}

	@Override
	public Admin findByNameAndPwd(Admin admin) {
		
		String sql = "SELECT *FROM admin WHERE userName = ? AND PASSWORD = ?";
		
		Object[] paramsValue = {admin.getUserName(),admin.getPassword()};
		List<Admin> admins = super.query(sql, paramsValue, Admin.class);
		
		return admins.get(0);
	}

	@Override
	public boolean adminExist(String name) {
		
		String sql = "SELECT id FROM admin WHERE userName = ?";
		Connection conn = null;
		PreparedStatement pStmt =null;
		
		ResultSet rs = null;
		try {
			
			conn = JdbcUtil.getConnection();
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			rs = pStmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				if(id > 0){
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, pStmt, rs);
		}
		
	}
	
}
