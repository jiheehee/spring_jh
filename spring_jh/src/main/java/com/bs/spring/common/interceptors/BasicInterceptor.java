package com.bs.spring.common.interceptors;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BasicInterceptor implements HandlerInterceptor{
	
	private LocalDateTime checkDate;
	//알트 쉬프트 에스 브이
	
	//지정된 controller의 매핑메소드가 실행되기 전에 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		
		checkDate = LocalDateTime.now();
		log.debug("----인터셉터 prehandle실행 ----");
		log.debug(request.getRequestURI());
		log.debug("------------------------------");
		//Object handler는 대상이 된 controller클래스정보를 저장한 객체
		HandlerMethod hm=(HandlerMethod)handler;  //다운캐스팅해줌
		//실행클래스 가져오기
		Object controller=hm.getBean();
		log.debug("{}",controller);
		//실행메소드 가져오기
		Method method=hm.getMethod();
		log.debug(method.getName());
		
		//return 값은 true가 되면 controller매핑메소드를 실행
		//		false가 되면 실행하지 않음
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		
		long lentency=ChronoUnit.MINUTES
						.between(checkDate, LocalDateTime.now());
		
		System.out.println(lentency+"s");
		
		log.debug("---- posthandle 실행 ----");
		Map<String,Object> model=modelAndView.getModel();
		log.debug("{}",model);
		String viewName=modelAndView.getViewName();
		log.debug(viewName);
//		modelAndView.addAllObjects(viewName,viewName)
		log.debug("-------------------------");
		
	}
	
	
	
	

}
