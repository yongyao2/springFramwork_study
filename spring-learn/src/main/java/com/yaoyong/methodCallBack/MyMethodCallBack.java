package com.yaoyong.methodCallBack;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//cglib  基于继承父类实现代理
public class MyMethodCallBack  implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		//相当于AOP的切点
		System.out.println("MyMethodCallBack----");
		return methodProxy.invokeSuper(o,objects);

	}
}
