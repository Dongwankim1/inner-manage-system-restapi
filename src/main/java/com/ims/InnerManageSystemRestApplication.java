package com.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ims.com.security.SpringSecurityConfig;

@SpringBootApplication
public class InnerManageSystemRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnerManageSystemRestApplication.class, args);
	}

}
