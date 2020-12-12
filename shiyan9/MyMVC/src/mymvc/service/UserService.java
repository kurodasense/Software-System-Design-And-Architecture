package mymvc.service;

import mymvc.po.User;

public interface UserService {
	public boolean login(User user);
	public Boolean checkUsername(String username);
	public int regist(User user);

}
