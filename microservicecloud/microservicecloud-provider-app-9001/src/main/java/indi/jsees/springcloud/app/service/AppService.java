package indi.jsees.springcloud.app.service;

import java.util.List;

import indi.jsees.springcloud.domain.User;

public interface AppService {
	
	public boolean add(User user);
	
	public User get(Long userId);
	
	public List<User> list();
	 
}
