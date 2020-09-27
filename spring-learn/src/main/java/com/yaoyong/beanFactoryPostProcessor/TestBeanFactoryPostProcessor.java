package com.yaoyong.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class TestBeanFactoryPostProcessor  implements BeanFactoryPostProcessor {

	//插手spring环境初始化的过程  插手Bean工厂，将一个bean设置为原型的，只需要实现BeanFactoryPostProcessor接口加上component注解
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AnnotatedBeanDefinition annotatedBeanDefinition= (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("yaoyongDao");
	   annotatedBeanDefinition.setScope("prototype");

	}
}
