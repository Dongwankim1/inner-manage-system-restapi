package com.ims.com.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDao {
	@Autowired 
	SqlSessionTemplate sqlSession;
	
	public <E> List<E> selectList(String queryId,Object parameterObject){
		return sqlSession.selectList(queryId,parameterObject);
	}
}
