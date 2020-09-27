package com.yaoyong.Service;

import com.yaoyong.dao.TestMyBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class TestMyBatisService {

	@Autowired
	TestMyBatisDao testMyBatisDao;


	public void select(){
		testMyBatisDao.select();
	}

	//@PostConstruct
	public void init(){
		System.out.println("TestMyBatisService init");
	}
}
