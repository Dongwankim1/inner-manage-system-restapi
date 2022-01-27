package com.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ims.com.security.SpringSecurityConfig;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class InnerManageSystemRestApplication extends SpringBootServletInitializer{
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(InnerManageSystemRestApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(InnerManageSystemRestApplication.class);
	}
	
	private static Class<InnerManageSystemRestApplication> applicationClass = InnerManageSystemRestApplication.class;
}
