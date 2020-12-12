package mymvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mymvc.dao.UserDao;
import mymvc.po.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean login(User user) {
		// TODO �Զ����ɵķ������
		User us = userDao.login(user);
		if(us != null) return true;
		else return false;
	}

	@Override
	public Boolean checkUsername(String username) {
		// TODO �Զ����ɵķ������
		User us = userDao.checkUsername(username);
		if(us != null) return true;
		else return false;
	}

	@Override
	public int regist(User user) {
		// TODO �Զ����ɵķ������
		int n = userDao.regist(user);
		return n;
	}
	
	
}
