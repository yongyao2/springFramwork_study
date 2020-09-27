package com.yaoyong.config;

import com.yaoyong.annotation.EnableYaoyong;
import com.yaoyong.annotation.YaoyongScan;
import com.yaoyong.dao.TestConfigration;
import com.yaoyong.dao.TestConfigration2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//加了这个注解会进行cglib的代理 不加的话就没有  看源码
@ComponentScan("com.yaoyong")
@YaoyongScan
@EnableYaoyong
public class AppConfig {


	@Bean
	public TestConfigration testConfigration(){
		return new TestConfigration();
	}

	@Bean
	public TestConfigration2 testConfigration2(){
		testConfigration();
		return new TestConfigration2();
	}
}
