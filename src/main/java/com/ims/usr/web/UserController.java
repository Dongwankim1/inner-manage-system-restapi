package com.ims.usr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/register")
	public Map<String, String> createUser(@RequestBody UserVo uservo) {
		
		int result = userCustomService.createUserInfo(uservo);
		
		
		Map<String,String> resultMap = new HashMap<String,String>();

		if(result ==-1) {
			resultMap.put("code", "exist");
			return resultMap;
		}else if(result >=1) {
			resultMap.put("code", "success");
			return resultMap;
		}else {
			resultMap.put("code", "error");
			return resultMap;
		}
	}
}
