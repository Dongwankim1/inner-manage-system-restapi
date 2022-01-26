package com.ims.usr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ims.com.mapper.CommonDao;
import com.ims.usr.vo.MemberVo;

@Service
public class MemberService {

		
		@Autowired
		BCryptPasswordEncoder bcryptPasswordEncoder;
	
		@Autowired
		private CommonDao commondao;
		
	
		
		
		public int createUserInfo(MemberVo memberVo) {
			int result =0;
			
			Map user = selectUserInfo(memberVo);
			if(user!=null) {
				return result = -1;
			}
			
			memberVo.setPassword(bcryptPasswordEncoder.encode(memberVo.getPassword()));
			
			
			result +=commondao.insert("MemberInfoMapper.insertUserInfo", memberVo);
			
			return result;
			
			
		}
		
		public Map<String, String> selectUserInfo(MemberVo memberVo) {
			
			return commondao.selectOne("MemberInfoMapper.selectUserInfo",memberVo);
		}
		
		public MemberVo loadUserByUsername(MemberVo memberVo) {
			MemberVo result = commondao.selectOneVo("MemberInfoMapper.selectOneLoadUser",memberVo);
			result.getRoles().add(result.getRole());
			return result;
		}
}
