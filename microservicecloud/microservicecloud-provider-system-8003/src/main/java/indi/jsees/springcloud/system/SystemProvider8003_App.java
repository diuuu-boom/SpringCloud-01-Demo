package indi.jsees.springcloud.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient		// 本服务启动后自动注册进eureka服务中
@EnableDiscoveryClient  // 服务发现
public class SystemProvider8003_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SystemProvider8003_App.class, args);
		System.out.println("系统system消费者8003已启动...");

	}

}
