package com.yaoyong.config;

import com.yaoyong.dao.TestAopDao;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("test1111")
public class TestAopDaoImpl implements TestAopDao {

	@Override
	public void query() {
		System.out.println("query");
	}

}
