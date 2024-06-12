package com.bs.spring.beantest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder

public class Animal {
	
	private String name;
	private int age;
	private double weight;
	
	private Animal() {
		System.out.println("동물생성!~._.");
	}
	
}
