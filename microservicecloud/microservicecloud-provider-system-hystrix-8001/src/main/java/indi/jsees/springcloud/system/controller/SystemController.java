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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import indi.jsees.springcloud.domain.User;
import indi.jsees.springcloud.system.service.SystemService;

@RestController
public class SystemController {
	
	@Autowired
	private SystemService systemService = null;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping(value="/system/add",method = RequestMethod.POST)
	public boolean add(@RequestBody User user) {
		return systemService.add(user);
	}
	
	@RequestMapping(value="/system/get/{userId}",method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get") // 一旦服务器调用失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallback
	public User get(@PathVariable("userId") Long userId) {
		User user = this.systemService.get(userId);
		if(user == null) {
			throw new RuntimeException("该用户ID:"+userId+"没有查询到对应信息.");
		}
		return systemService.get(userId);
	}
	
	public User processHystrix_Get(@PathVariable("userId")Long userId) {
		return new User().setUsername("该userId: "+userId+"没有对应的信息,null --@@HystrixCommand").setAge(0).setGender(2).setHobby("未注册账号")
				.setDb_source("no this database in MySQL");
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
