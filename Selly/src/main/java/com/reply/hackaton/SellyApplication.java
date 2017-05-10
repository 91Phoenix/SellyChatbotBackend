package com.reply.hackaton;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.reply.hackaton.model.IntentExecutorFactory;

@SpringBootApplication
@ComponentScan
public class SellyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellyApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	ServiceLocatorFactoryBean myServiceFactory(){
		ServiceLocatorFactoryBean locatorFactoryBean = new ServiceLocatorFactoryBean();
		locatorFactoryBean.setServiceLocatorInterface(IntentExecutorFactory.class);
		
		return locatorFactoryBean;
	}

}
