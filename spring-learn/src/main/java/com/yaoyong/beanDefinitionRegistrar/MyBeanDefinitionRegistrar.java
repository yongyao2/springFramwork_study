package com.yaoyong.beanDefinitionRegistrar;

import com.yaoyong.dao.TestMyBatisDao;
import com.yaoyong.factoryBean.MyFactoryBean;
import com.yaoyong.test.SpringTest;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//模拟mybtais源码
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

		BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(TestMyBatisDao.class);
		GenericBeanDefinition genericBeanDefinition= (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();

		//动态通过构造器
		genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.yaoyong.dao.TestMyBatisDao");
		//MyFactoryBean 会注册2个对象 返回代理对象
		genericBeanDefinition.setBeanClass(MyFactoryBean.class);

		registry.registerBeanDefinition("testMyBatisDao",genericBeanDefinition);


	}


}
