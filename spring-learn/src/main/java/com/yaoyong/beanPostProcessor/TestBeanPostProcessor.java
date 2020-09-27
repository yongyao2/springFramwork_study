package com.yaoyong.beanPostProcessor;

import com.yaoyong.dao.YaoyongDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

//BeanPostProcessor  一个扩展类点 Aop就是这样做的
// 还有很多扩展类点  spring 提供了很多这种扩展类
// 主要用来插手bean 干预做一些其他的事情
//@Component
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println(beanName);
		if(beanName.equals("yaoyongDao")){
			System.out.println("init之前");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println(beanName);
		if(beanName.equals("yaoyongDao")){
			System.out.println("init之后");
		}
		return bean;
	}

	//扩展类加载顺序
	@Override
	public int getOrder() {
		return 2;
	}
}
