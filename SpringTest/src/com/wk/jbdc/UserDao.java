package com.wk.jbdc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class UserDao{

	/*//注入容器
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	
	
	private JdbcTemplate jdbcTemplate;
	public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	public void add(User user){
		
		String sql = "insert into user (userName,password) values (?,?)";
		jdbcTemplate.update(sql,user.getUserName(),user.getPassword());
	}
	
	public User findById(int id) {
		
		
//		PreparedStatement pStat = null;
		String sql = "select * from user where id=?";
		
		//使用JdbcTemplate类操作sql
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg) throws SQLException {
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		},id);
		
		return (list != null && list.size() > 0) ? list.get(0) : null;
		
	}
	
	
	public List<User> findAll(){

		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg) throws SQLException {
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		
		return (list != null && list.size() > 0) ? list : null;
	}
}
