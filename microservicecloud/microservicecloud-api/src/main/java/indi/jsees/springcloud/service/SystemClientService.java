package indi.jsees.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import indi.jsees.springcloud.domain.User;


//@FeignClient(value = "MICROSERVICECLOUD-SYSTEM")
@FeignClient(value = "MICROSERVICECLOUD-SYSTEM",fallbackFactory=SystemClientServiceFallbackFactory.class)
public interface SystemClientService {
	
	@RequestMapping(value="/system/get/{userId}",method = RequestMethod.GET)
	public User get(@PathVariable("userId") long userId);
	
	@RequestMapping(value="/system/list",method = RequestMethod.GET)
	public List<User> list();
	
	@RequestMapping(value="/system/add",method = RequestMethod.POST)
	public boolean add(User user);

}
