package com.bs.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private final Logger logger=LoggerFactory.getLogger(MainController.class);
	
	//log4j가 제공하는 Logger를 이용해서 로그메시지 출력하기
	//이 메세지들이 level이 됨
	// 큰 범위 순서 debug > info > warn > error 이게 레벨 수준 (레벨로 조정해서 출력하는거고)
	// 예를들어 info출력하면 info > warn > error 이렇게 출력
	//debug()
	//ingo()
	//warn
	//error()
	
	@RequestMapping("/")		
	public String index(HttpSession session, 
					HttpServletResponse response) {
	
		logger.debug("debug로그 출력");
		logger.info("info로그 출력");
		logger.warn("warn로그 출력");
		logger.error("error로그 출력");
		
		session.setAttribute("sessionId", "GDJ79");
		Cookie c=new Cookie("cookieData","cookiecookie");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		return "index";
	}
	
	
	
	
}



