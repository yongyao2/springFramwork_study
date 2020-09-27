package com.yaoyong.dao;

import com.yaoyong.invocationHandler.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestImportSelectorDao implements BeanPostProcessor{



	public void query() {
		System.out.println("TestImportSelectorDao 我不需要加注解哦");
	}

	//初始化之前
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("testAopDaoImpl")) {
			bean = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{TestAopDao.class},
					new MyInvocationHandler(bean));
		}
		return bean;
	}

	//初始化之后
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}


}
