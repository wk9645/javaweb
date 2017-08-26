package com.wk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.wk.jdbc_util.JdbcUtil;

public class BaseDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	 	ͨ��Dao������Ϊ�����Զ���Dao�ĸ���
	 	�������ºͲ�ѯ��������
	 */
	
	/**
	 * ���·�����insert��delete��update
	 * @param sql	Ҫִ�и��µ�sql���
	 * @param paramsValue	Ԥ������ռλ����Ӧ��ֵ	 
	 */
	public void update(String sql, Object[] paramsValue){
		
		try {
			//�������Ӳ�����Ԥ����
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//��ȡԤ�����������
			int count = pstmt.getParameterMetaData().getParameterCount();
			//��ֵ��������
			if(paramsValue != null && paramsValue.length > 0){
				for(int i=0; i<count; i++){
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			//ִ��
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtil.close(conn, pstmt);
		}
		
	}
	
	/**
	 * ͨ�õĲ�ѯ����
	 * @param sql	Ҫִ�е�sql���
	 * @param paramsValue	����ֵ
	 * @param clazz	�������
	 */
	public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz){
		
		//����һ��List
		List<T> list = new ArrayList<T>();
		//��������
		T t = null;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//��ȡ��������
			int count = pstmt.getParameterMetaData().getParameterCount();
			//���ò���ֵ
			if(paramsValue != null && paramsValue.length > 0){
				for(int i=0; i<count; i++){
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			//ִ��sql
			rs = pstmt.executeQuery();
			ResultSetMetaData rs_meta = rs.getMetaData();
			int columns = rs_meta.getColumnCount();
			//����ÿ��ÿ��
			while(rs.next()){
				//ÿһ�д���һ������
				t = clazz.newInstance();
				
				for(int i=0; i<columns; i++){
					String item = rs_meta.getColumnName(i+1);
					Object value = rs.getObject(item);
					//�����ݷ�װ����������
					BeanUtils.copyProperty(t, item, value);
				}
				//��һ��������ӵ�������
				list.add(t);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}	
