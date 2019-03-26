package com.gmself.bingobingo;

import com.gmself.bingobingo.module.subject.aop.SubjectAspect;
import com.gmself.bingobingo.module.subject.db.dao.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@MapperScan(
		basePackages = "com.gmself.bingobingo.module",
		sqlSessionFactoryRef = "sqlSessionFactory",
		sqlSessionTemplateRef = "sqlSessionTemplate",
		annotationClass = Repository.class
)
//@ImportResource(locations = {"classpath:beans.xml"})
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //mybatis自动配置数据源
@SpringBootApplication() //mybatis自动配置数据源
public class BingobingoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BingobingoApplication.class, args);
	}

	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	@Bean(name = "subjectAspect")
	public SubjectAspect initSubjectAspect(){
		return new SubjectAspect();
	}

}
