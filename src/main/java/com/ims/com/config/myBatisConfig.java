package com.ims.com.config;

import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value = "com.ims",sqlSessionFactoryRef = "SqlSessionFactory")
public class myBatisConfig {
	@Value("${spring.datasource.mapper-locations}")
	String mybatisPath;
	
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="SqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource Datasource,ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(Datasource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mappers/*.xml"));
		
		Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(myBatisConfig);
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "SessionTemplate")
	public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
		return new SqlSessionTemplate(firstSqlSessionFactory);
	}
}
