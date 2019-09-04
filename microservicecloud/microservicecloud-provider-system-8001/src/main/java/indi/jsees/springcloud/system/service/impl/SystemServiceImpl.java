package indi.jsees.springcloud.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.system.dao.SystemDao;
import indi.jsees.springcloud.system.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	SystemDao systemDao;
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return systemDao.addUser(user);
	}

	@Override
	public User get(Long userId) {
		// TODO Auto-generated method stub
		return systemDao.findById(userId);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return systemDao.findAll();
	}

}
