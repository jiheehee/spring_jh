package com.bs.spring.beantest.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bs.spring.beantest.dao.BeanDao;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class BeanServiceImpl implements BeanService{
   
   private BeanDao dao;
   
   public BeanServiceImpl(
		   @Qualifier("testDao") BeanDao dao){
			   super();
			   this.dao=dao;
		   }
		   
   
   
   @Override
   public void testService() {
      System.out.println("beanService 실행");
      dao.findBean();
   }
}
