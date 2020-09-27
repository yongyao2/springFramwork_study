package com.yaoyong.dao;

import org.springframework.stereotype.Component;

@Component
public class TestAopDaoImpl implements TestAopDao {

	@Override
	public void query() {
		System.out.println("query");
	}
}
