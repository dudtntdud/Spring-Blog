package com.seokwon.blog;

import javax.sql.DataSource;

import com.seokwon.blog.Interceptor.CertificationInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan(value = {"com.seokwon.blog.mapper"})
public class SpringprojectApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}


	/**
	 * SqlSessionFactory 설정
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");

		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}

	/**
	 * HiddenHttpMethodFilter
	 */
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
		return filter;
	}

	/*
     * CertificationInterceptor
     * */
	@Autowired
	CertificationInterceptor certificationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(certificationInterceptor)
				.addPathPatterns("/board/post/*");
	}
}
