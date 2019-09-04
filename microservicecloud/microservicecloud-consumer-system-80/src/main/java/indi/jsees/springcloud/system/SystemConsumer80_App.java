package indi.jsees.springcloud.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import indi.jsees.springcloud.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务的时候就能加载我们的自定义Ribbon 配置类,从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-SYSTEM",configuration=MySelfRule.class)
@RibbonClient(name="MICROSERVICECLOUD-SYSTEM",configuration=MySelfRule.class)
public class SystemConsumer80_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SystemConsumer80_App.class, args);
		System.out.println("系统system消费者80端口已启动....");
	}

}
