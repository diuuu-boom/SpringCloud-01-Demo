package indi.jsees.springcloud.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自己定义负载均衡算法
 * @author Administrator
 *
 */

public class RandomRule_PY extends AbstractLoadBalancerRule {

	// total = 0 // 当total==5以后,我们指针才能往下走,
	// index = 0 // 当前对外提供服务的服务器地址,
	// total 需要重置为0 ,但是已经达到过一个 5 次, 我们的index = 1
	// 分析: 我们 5 次,但是已经达到过一个5次,我们的index = 1
	private int total = 0;      // 总共被调用的次数,目前要求每台被调用 5 次
	private int currentIndex = 0;  // 当前提供服务的机器号
	
	public Server choose(ILoadBalancer lb,Object key) {
		
		if(lb == null) {
			return null;
		}
		Server server = null;
		while(server == null) {
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			
			int serverCount = allList.size();
			if(serverCount == 0) {
				return null;
			}
			
//			int index = rand.nextInt(serverCount);  // java.util.Randomo().nextInt(3);
//			server = upList.size(index);
			
			if(total < 5) {
				server = upList.get(currentIndex);
				total++;
			}else {
				total = 0;
				currentIndex++;
				if(currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}
			
			if(server == null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server = null;
			Thread.yield();
		}
		
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(),key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

}
