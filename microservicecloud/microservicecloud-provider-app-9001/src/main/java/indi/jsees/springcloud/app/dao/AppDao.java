package indi.jsees.springcloud.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import indi.jsees.springcloud.domain.User;

@Mapper
public interface AppDao {
	
	public boolean addUser(User user);
	
	public User findById(Long userId);
	
	public List<User> findAll();
	

}
