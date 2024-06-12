package com.bs.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.spring.beantest.Animal;
import com.bs.spring.beantest.BeanTest;
import com.bs.spring.beantest.Food;
import com.bs.spring.beantest.Person;
import com.google.gson.Gson;

@Controller

public class HomeController {
	
	//Spring bean에 특정 클래스를 등록해두고 의존성 주입해서 객체로 사용해주는 과정
//	@Autowired    // (bean으로 연결된 애 중에 Animal로 연결된 애 있으면) 자동으로 연결해라 -> 의존성 주입
//	private Animal a; // Animal a=new Animal(); 이거 안해줘도 객체 자동 생성됨 !! -> 이게 스프링 ~ 
	//의존성 주입을 해줬기때문에! 
	// Animal 이 타입을 보고 들어가는거임
	
//	@Autowired
//	private Animal obok; //obok과 아이디 값이 일치한 것을 넣어줌
//	@Autowired
//	private Animal dosoon;
	
	@Autowired
	private Person p;
	
	@Autowired
	private List<Animal> animals;
	
	@Autowired
	private List<Person> persons;
	
	
  @Autowired 
  @Qualifier("obok") 
  private Animal a;	 
  
  @Autowired
  private BeanTest bean;
  
  @Autowired
  private Food food;
  
  @Autowired
  private Food gom;
  
  @Autowired
  private Gson gson;
  
  @RequestMapping("/gson")
  @ResponseBody
  public void data(HttpServletResponse response)throws Exception {
	  gson.toJson(gom,response.getWriter());
  }
  
  @Autowired
  private List<Food> foods;
  
	
	@RequestMapping("/test1")
	public String home() {
		System.out.println("메인화면으로 연결");
		System.out.println(a);
		System.out.println(p);
//		System.out.println(obok);
//		System.out.println(dosoon);
		System.out.println(animals);
		System.out.println(persons);
		System.out.println(bean);
		System.out.println(food);
		System.out.println(gom);
		System.out.println(foods);
		return "index";
	}
	
	

}
