package com.bs.spring.beantest;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component //이 어노테이션으로 선언하면 bean등록됨
// @Primary 얘를 최우선으로 등록해! 라는 뜻 ~
public class BeanTest {
	
	private String title="어노테이션빈";
	

}
