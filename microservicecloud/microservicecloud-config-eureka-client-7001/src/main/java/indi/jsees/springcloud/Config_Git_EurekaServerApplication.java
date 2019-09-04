package indi.jsees.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Config_Git_EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
		System.out.println("eureka 已启动...");
	}
	
}
