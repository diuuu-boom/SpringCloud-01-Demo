package indi.jsees.springcloud.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"indi.jsees.springcloud"})
@ComponentScan("indi.jsees.springcloud")
public class SystemConsumer80_Feign_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SystemConsumer80_Feign_App.class, args);
		System.out.println("系统system 集成Feign 消费者80端口已启动....");
	}

}
