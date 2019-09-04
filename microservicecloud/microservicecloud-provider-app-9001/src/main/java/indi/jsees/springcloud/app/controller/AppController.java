package indi.jsees.springcloud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.app.service.AppService;

@RestController
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping(value="/app/add",method = RequestMethod.POST)
	public boolean add(@RequestBody User user) {
		return appService.add(user);
	}
	
	@RequestMapping(value="/app/get/{userId}",method = RequestMethod.GET)
	public User get(@PathVariable("userId") Long userId) {
		return appService.get(userId);
	}

	@RequestMapping(value="/app/list",method = RequestMethod.GET)
	public List<User> list(){
		return appService.list();
	}
	
	@RequestMapping(value="/app/discovery",method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println("***********" + list);
		List<ServiceInstance> serList = discoveryClient.getInstances("MICROSERVICECLOUD-APP");
		for(ServiceInstance element : serList) {
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getUri());
		}
		return this.discoveryClient;
	}
	
}
