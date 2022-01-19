package com.ims.com.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDao {
	
	@Qualifier("SessionTemplate")
	@Autowired 
	SqlSessionTemplate sqlSession;
	
	public <E> List<E> selectList(String queryId,Object parameterObject){
		return sqlSession.selectList(queryId,parameterObject);
	}
	
	public <E> Map<E,E> selectOne(String queryId,Object parameterObject){
		return sqlSession.selectOne(queryId,parameterObject);
	}
	

	public int insert(String queryId,Object parameterObject) {
		return sqlSession.insert(queryId,parameterObject);
	}
}
