package com.yaoyong.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

//@Repository
public class YaoyongDao implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public YaoyongDao() {
		System.out.println("构造方法");
	}

	@PostConstruct
	public void init() {
		System.out.println("初始化类");
	}

	public void query() {
		System.out.println("query");
		//.out.println(applicationContext.getBean("XXX"));每次拿到的都是最新的bean实例 在多例模式下可以这样使用
	}

	//设置一个 applicationContext  关联源码
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		//System.out.println(applicationContext);
	}
}
