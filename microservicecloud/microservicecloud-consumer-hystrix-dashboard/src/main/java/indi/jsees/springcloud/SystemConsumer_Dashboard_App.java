package indi.jsees.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SystemConsumer_Dashboard_App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SystemConsumer_Dashboard_App.class, args);
		System.out.println("消费者system 集成 HystrixDashboard 已经启动...");
		
	}

}
