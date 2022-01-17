package com.ims.usr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ims.com.mapper.CommonDao;
import com.ims.usr.vo.UserVo;

@Service
public class UserCustomService {

		
		@Autowired
		BCryptPasswordEncoder bcryptPasswordEncoder;
	
		@Autowired
		private CommonDao commondao;
		
	
		
		
		public int createUserInfo(UserVo uservo) {
			int result =0;
			
			Map user = selectUserInfo(uservo);
			if(user!=null) {
				return result = -1;
			}
			
			uservo.setPassword(bcryptPasswordEncoder.encode(uservo.getPassword()));
			
			
			result +=commondao.insert("UserInfoMapper.insertUserInfo", uservo);
			
			return result;
			
			
		}
		
		public Map<String, String> selectUserInfo(UserVo uservo) {
			
			return commondao.selectOne("UserInfoMapper.selectUserInfo",uservo);
		}
}
