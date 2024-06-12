package com.bs.spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;

import com.bs.spring.beantest.BeanTest;
import com.bs.spring.beantest.Food;
import com.bs.spring.beantest.Person;
import com.google.gson.Gson;

@Configuration //하나의 설정파일 -> springbean configuration.xml과 동일
//servlet-context.xml파일에서 bean등록한거나 이거나 같음
@ComponentScan(basePackages = "com.bs.spring",
	includeFilters =  {@ComponentScan.Filter(
			type=FilterType.REGEX,  //이 타입이 있어야지 밑에줄 문자열 해석하는 방식임
			pattern = "com.bs.spring.beantest.test.*")}
		)
public class TestConfig {

	//bean 등록하기
	//@Bean어노테이션이 선언된 메소드를 선언
	@Bean(name="f")
	public Food food() { //Food 얘가 bean으로 등록되는거임
		return Food.builder().build();
	}
	
	// 이렇게 하면 오류납니다!
	// 왜냐면 @Autowired했을때 type을 기준으로 가지고 오는데 Food가 두개라서 오류남
	// 해결법 1. bean에 대한 이름 , 2. @퀄리파이 
	// 해결법 1을 사용하는 방법은 컨트롤러에   
//	  @Autowired
//	  private Food food; 메소드명 food적어주기 (메소드명이 bean의 id값임)
	@Bean(name="food")
	public Food food2() {
		return Food.builder().name("피자").price(25000).build();
	}
	
	@Bean(name="gom")
	public Food food3(List<Person> persons) {
		return Food.builder()
				.name("곰탕")
				.likePerson(persons)
				.price(9000)
				.build();
	}
	@Bean(name="gom2")
	public Food food4(@Qualifier("p") Person per) {
		return Food.builder()
				.name("곰탕")
				.likePerson(List.of())
				.price(9000)
				.build();
	}
//	@Bean(name="gom")
//	public Food food3(@Autowired List<Person> persons) { 실제로 @Autowired안써도 쓴 것처럼 기능함
//		return Food.builder()
//				.name("곰탕")
//				.likePerson(persons)
//				.price(9000)
//				.build();
//	}
	
	@Bean
	@Primary
	public BeanTest listBean() {
		List<Food> foods=List.of(food(),food2());
		return new BeanTest();
	}
	
	@Bean
	public Gson gson() {
		Gson gson=new Gson();
		gson.newBuilder();
		return new Gson();		
	}
	
	/*
	 * @Bean public BasicDataSource dataSource() { BasicDataSource source=new
	 * BasicDataSource(); }
	 */
	
	
}
