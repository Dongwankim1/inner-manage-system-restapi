package com.ims.usr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.usr.mapper.UserInfoMapper;
import com.ims.usr.vo.UserVo;

@Service
public class UserCustomService {
		@Autowired
		private UserInfoMapper mapper;
		
		public List<UserVo> selectUserInfo(){
			return mapper.selectUserInfo();
		}
}
