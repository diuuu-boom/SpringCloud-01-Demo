package indi.jsees.springcloud.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.ribbon.proxy.annotation.Hystrix;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.system.service.SystemService;

@RestController
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping(value="/system/add",method = RequestMethod.POST)
	public boolean add(@RequestBody User user) {
		return systemService.add(user);
	}
	
	
	
	@RequestMapping(value="/system/get/{userId}",method = RequestMethod.GET)
	public User get(@PathVariable("userId") Long userId) {
		return systemService.get(userId);
	}

	@RequestMapping(value="/system/list",method = RequestMethod.GET)
	public List<User> list(){
		return systemService.list();
	}
	
	@RequestMapping(value="/system/discovery",method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println("***********" + list);
		List<ServiceInstance> serList = discoveryClient.getInstances("MICROSERVICECLOUD-SYSTEM");
		for(ServiceInstance element : serList) {
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getUri());
		}
		return this.discoveryClient;
	}
	
}
