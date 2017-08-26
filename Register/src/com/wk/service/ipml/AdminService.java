package com.wk.service.ipml;

import com.wk.dao.impl.AdminDao;
import com.wk.entity.Admin;
import com.wk.exception.AdminExistsException;
import com.wk.service.IAdminService;

public class AdminService implements IAdminService{

	private AdminDao ad = new AdminDao();
			
	@Override
	public void register(Admin admin) throws AdminExistsException {
		
		try {
			//����û����Ƿ����
			boolean isExist = ad.adminExist(admin.getUserName());
			//������ڣ����׳��쳣
			if(isExist){
				throw new AdminExistsException("�û����Ѵ��ڣ�");	
			}
			
			//��������ڣ��򱣴��û�
			ad.save(admin);
		}catch (AdminExistsException e) {
			throw e;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		
	}

	@Override
	public Admin login(Admin admin) {

		return ad.findByNameAndPwd(admin);
		
	}

}
