package com.ims.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ims.com.jwt.JwtAuthenticationFilter;
import com.ims.com.jwt.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable()
		.csrf().disable() // csrf 보안 토큰 disable 처리
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//토큰 기반 인증이므로 세션 역시 사용하지 않습니다.

		
		http.authorizeRequests() // 요청에 대한 사용권한 체크
		.antMatchers("/calendar/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.antMatchers("/api/v1/user/**").permitAll()
		.anyRequest().authenticated();

		http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
}
