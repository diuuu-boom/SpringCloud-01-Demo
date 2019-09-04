package indi.jsees.springcloud.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.app.dao.AppDao;
import indi.jsees.springcloud.app.service.AppService;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	AppDao appDao;
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return appDao.addUser(user);
	}

	@Override
	public User get(Long userId) {
		// TODO Auto-generated method stub
		return appDao.findById(userId);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return appDao.findAll();
	}

}
