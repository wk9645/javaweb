package com.wk.tx;

import org.springframework.jdbc.core.JdbcTemplate;



public class UserDao{

	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void add(User user){
		
		
		String sql = "insert into user (userName,password) values (?,?)";
		jdbcTemplate.update(sql,user.getUserName(),user.getPassword());
	}
	
	
//	public User findById(){
//		return null;
//		
//	}
//	
//	public List<User> findAll(){
//		return null;
//		
//		
//		
//	}
}
