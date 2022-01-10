package com.ims.usr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.com.mapper.CommonDao;
import com.ims.usr.mapper.UserInfoMapper;
import com.ims.usr.vo.UserVo;

@Service
public class UserCustomService {

		
		@Autowired
		private CommonDao commondao;
		
		public List<UserVo> selectUserInfo(){
			UserVo a = new UserVo();
			//return mapper.selectUserInfo();
			return commondao.selectList("UserInfoMapper.selectUserInfo", a);
		}
}
