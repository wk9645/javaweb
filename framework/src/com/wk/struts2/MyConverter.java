package com.wk.struts2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyConverter extends StrutsTypeConverter{

	
	/**
	 * ��String����D�Q��ָ�����
	 * @param context ��ǰ�����ĭh��
	 * @param values jsp����ύ���ַ�����ֵ
	 * @param toClass Ҫ�D�Q��Ŀ�����
	 * 
	 */
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		
		if(values == null && values.length == 0)
			return null;
		if(Date.class != toClass)
			return null;
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
			return sdf.parse(values[0]);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}
	

}
