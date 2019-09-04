package indi.jsees.springcloud.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import indi.jsees.springcloud.domain.User;

@RestController
public class SystemController_Consumer {
	
//	private static final String REST_URL_PREFIX =  "http://localhost:8001";
//	private static final String REST_URL_PREFIX1 = "http://localhost:9001";
	// 真正意义上通过微服务的名字来注册进 eureka
	private static final String REST_URL_PREFIX =  "http://MICROSERVICECLOUD-SYSTEM";
	private static final String REST_URL_PREFIX1 = "http://MICROSERVICECLOUD-APP";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 使用restTemplate 访问restful 接口非常简单.(url,requestMap,ResponseBean.class)
	 * 这三个参数分别代表 REST 请求地址、请求参数、HTTP 响应装换成的对象类型。
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/consumer/system/add")
	public boolean add(User user) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/system/add",user, Boolean.class);
	}
	
	@RequestMapping(value="/consumer/system/get/{userId}")
	public User get(@PathVariable("userId") Long userId) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/system/get/"+userId, User.class);
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/system/list")
	public List<User> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/system/list",List.class);
	}
	
	
	/*
	 * @RequestMapping(value="/consumer/app/get/{userId}") public User
	 * get1(@PathVariable("userId") Long userId) { return
	 * restTemplate.getForObject(REST_URL_PREFIX1+"/app/get/"+userId, User.class); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value="/consumer/app/list") public List<User> list1(){ return
	 * restTemplate.getForObject(REST_URL_PREFIX1+"/app/list",List.class); }
	 */
	
}
