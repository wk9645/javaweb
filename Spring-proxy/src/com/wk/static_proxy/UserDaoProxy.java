package com.wk.static_proxy;

public class UserDaoProxy implements IUserDao {

	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void save() {
		
		System.out.println("��ʼ����111");
		
		userDao.save();
		
		System.out.println("�ύ����");
	}

}
