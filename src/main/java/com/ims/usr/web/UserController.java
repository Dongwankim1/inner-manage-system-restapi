package com.ims.usr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ims.usr.service.UserCustomService;

import com.ims.usr.vo.UserVo;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	UserCustomService userCustomService;
	
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/info")
	public List<UserVo> selectInfo() {
		System.out.println("dddd"+userCustomService.selectUserInfo());
		return userCustomService.selectUserInfo();
	}
	
	@PostMapping("/register")
	public void createUser() {
		
	}
}
