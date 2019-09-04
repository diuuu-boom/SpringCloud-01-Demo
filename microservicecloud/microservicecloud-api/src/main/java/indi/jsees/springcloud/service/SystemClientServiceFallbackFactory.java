package indi.jsees.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import indi.jsees.springcloud.domain.User;

@Component  // 不要忘记添加
public class SystemClientServiceFallbackFactory implements FallbackFactory<SystemClientService> {

	@Override
	public SystemClientService create(Throwable throwable) {
		// TODO Auto-generated method stub
		return new SystemClientService() {
			
			@Override
			public List<User> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public User get(long userId) {
				return new User().setUsername("该userId: "+userId+"没有对应的信息,Consumer客户端提供降级信息,此刻服务Provider已经关闭 --@@HystrixCommand")
						.setAge(0).setGender(2).setHobby("未注册账号")
						.setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(User user) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
