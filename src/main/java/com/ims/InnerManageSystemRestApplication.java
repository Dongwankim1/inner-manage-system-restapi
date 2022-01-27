package com.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ims.com.security.SpringSecurityConfig;

@SpringBootApplication
public class InnerManageSystemRestApplication extends SpringBootServletInitializer{
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(InnerManageSystemRestApplication.class, args);
	}

}
