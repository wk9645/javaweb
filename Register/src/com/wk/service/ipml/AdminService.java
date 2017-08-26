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
			//检查用户名是否存在
			boolean isExist = ad.adminExist(admin.getUserName());
			//如果存在，则抛出异常
			if(isExist){
				throw new AdminExistsException("用户名已存在！");	
			}
			
			//如果不存在，则保存用户
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
