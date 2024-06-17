package com.bs.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.bs.spring.common.exception.BadAuthenticationException;

@Configuration
public class WebMVCConfig {

	//예외처리할 bean을 등록해서 활용할 수 있음
	//HandlerExceptionResolver을 구현한 구현체
	@Bean
	public HandlerExceptionResolver handleException() {
		
		SimpleMappingExceptionResolver smer=new SimpleMappingExceptionResolver();
		
		Properties mappingException=new Properties();
		mappingException.setProperty(BadAuthenticationException.class.getName(), "common/error/authentication"); //연결할 뷰 주소 //얘도 전환될때 반환될
		
		smer.setExceptionMappings(mappingException);
		
		smer.setDefaultErrorView("common/error/error"); //property는 key value
		return smer;
		
	}
	
	
}


