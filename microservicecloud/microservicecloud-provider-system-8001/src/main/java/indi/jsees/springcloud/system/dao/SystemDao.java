package indi.jsees.springcloud.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import indi.jsees.springcloud.domain.User;

@Mapper
public interface SystemDao {
	
	public boolean addUser(User user);
	
	public User findById(Long userId);
	
	public List<User> findAll();
	

}
