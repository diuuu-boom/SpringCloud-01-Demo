package indi.jsees.springcloud.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.service.SystemClientService;

@RestController
public class SystemController_Consumer {
	
	@Autowired
	private SystemClientService systemClientService;
	
	@RequestMapping(value = "/consumer/system/get/{userId}")
	public User get(@PathVariable("userId") Long userId) {
		return this.systemClientService.get(userId);
	}
	
	@RequestMapping(value = "/consumer/system/list")
	public List<User> list(){
		return this.systemClientService.list();
	}
	
	@RequestMapping(value = "/consumer/system/add")
	public Object add(User user) {
		return this.systemClientService.add(user);
	}
	
}
