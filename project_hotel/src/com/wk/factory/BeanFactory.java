package com.wk.factory;

import java.util.ResourceBundle;

public class BeanFactory {
	
	private static ResourceBundle bundle;
	
	static{
		bundle = ResourceBundle.getBundle("instance");
	}
	
	/**
	 *����ָ����key��ѡȡ�����ļ���ȡ���ȫ·������������
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> T getInstance(String key,Class<T> clazz){
		
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
