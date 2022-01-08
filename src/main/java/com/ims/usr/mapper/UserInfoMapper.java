package com.ims.usr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ims.usr.vo.UserVo;

@Repository
@Mapper
public interface UserInfoMapper {
	List<UserVo> selectUserInfo();
}
