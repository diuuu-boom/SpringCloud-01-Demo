package indi.jsees.springcloud.system.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean { //boot ->spring application.xml--- @Configuration 配置 ConfigBean = application.xml

	@Bean
	@LoadBalanced  // springcloud Ribbon 是基于Netflix Ribbon实现的一套客户端  负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
//		return  new RoundRobinRule(); // 达到目的,用我们重选的算法替代默认的轮询
		return new RandomRule();
	}
	
	
}
// @Bean
// public UserService getUserService(){
// 
// 		return new UserServiceImpl();
//
//}
// applicationContext.xml == ConfigBean(@Configuration)
// <bean id="userService" class="com.indi.jsees.service.impl.UserServiceImpl">
