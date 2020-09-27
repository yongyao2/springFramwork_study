package com.yaoyong.factoryBean;

import com.yaoyong.dao.TestMyBatisDao;
import com.yaoyong.test.SpringTest;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean, InvocationHandler {
	Class aClass;

	public MyFactoryBean(Class aClass){
		this.aClass=aClass;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("MyFactoryBean -->invoke-->拿到sql语句");
		Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName());
		Select declaredAnnotation = method1.getDeclaredAnnotation(Select.class);
		System.out.println(declaredAnnotation.value()[0]);
		return null;
	}

	@Override
	public Object getObject() throws Exception {
		//生成TestMyBatisDao的代理对象
		Class[]classes=new Class[]{aClass};
		Object proxyInstance= (TestMyBatisDao) Proxy.newProxyInstance(this.getClass().getClassLoader(),classes,this);
		return proxyInstance;
	}

	@Override
	public Class<?> getObjectType() {
		return aClass;
	}
}
