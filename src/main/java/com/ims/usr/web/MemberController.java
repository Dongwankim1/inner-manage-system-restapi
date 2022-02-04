package com.ims.usr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.ims.com.jwt.JwtTokenProvider;
import com.ims.usr.service.MemberService;

import com.ims.usr.vo.MemberVo;

@RestController
@RequestMapping("/api/v1/user")
public class MemberController {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	MemberService userCustomService;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}

	@PostMapping("/register")
	@ResponseBody
	public Map<String, String> createUser(@RequestBody MemberVo memberVo) {
		

		int result = userCustomService.createUserInfo(memberVo);
		
		
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
	
	@PostMapping("/login")
	public String login(@RequestBody MemberVo memberVo) {
		Map<String,String> user = userCustomService.selectUserInfo(memberVo);
		JsonObject obj = new JsonObject();
		
		if(user ==null) {
			obj.addProperty("code", "none");
			return obj.toString();
		}
		
		if(!bCryptPasswordEncoder.matches(memberVo.getPassword(), user.get("password"))) {
			obj.addProperty("code", "diff");
			return obj.toString();
		}
		obj.addProperty("code", "success");
		obj.addProperty("token", jwtTokenProvider.createToken(user.get("email"), user.get("role")));
		
		return obj.toString();
		
		
	}
	
	@PostMapping("/auth")
	public String auth(@RequestBody MemberVo memberVo) {
		return null;
		
		
	}
}
