package com.mycoolprojects.shopmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringReactGradleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringReactGradleApplication.class, args);
	}
}