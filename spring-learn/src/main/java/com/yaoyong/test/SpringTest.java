package com.yaoyong.test;

import com.yaoyong.Service.TestMyBatisService;
import com.yaoyong.beanFactoryPostProcessor.TestBeanFactoryPostProcessor;
import com.yaoyong.config.AppConfig;
import com.yaoyong.dao.TestAopDao;
import com.yaoyong.dao.TestCglib;
import com.yaoyong.dao.TestImportSelectorDao;
import com.yaoyong.dao.YaoyongDao;
import com.yaoyong.methodCallBack.MyMethodCallBack;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		//第一种初始化spring环境方式
//		AnnotationConfigApplicationContext annotationConfigApplicationContext=
//				new AnnotationConfigApplicationContext(AppConfig.class);
//		YaoyongDao yaoyongDao=annotationConfigApplicationContext.getBean(YaoyongDao.class);
//		yaoyongDao.query();

		//第二种方式
		//准备spring所有的前提环境
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(AppConfig.class);
		// 这就是自定义的后置处理器（手动交给spring管理的类）
		// 加了注解就是spring管理的后置处理器
		//DefaultListableBeanFactory工厂制造结束 有如下几个bd
		// [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,--》重要
		// org.springframework.context.annotation.internalAutowiredAnnotationProcessor,
		// org.springframework.context.annotation.internalCommonAnnotationProcessor,
		// org.springframework.context.event.internalEventListenerProcessor,
		// org.springframework.context.event.internalEventListenerFactory,
		// appConfig
		//初始化spring的环境
		annotationConfigApplicationContext.refresh();


		//TestMyBatisService bean = annotationConfigApplicationContext.getBean(TestMyBatisService.class);
		//bean.select();
		//YaoyongDao yaoyongDao=annotationConfigApplicationContext.getBean(YaoyongDao.class);
		//yaoyongDao.query();
		//YaoyongDao yaoyongDao1=annotationConfigApplicationContext.getBean(YaoyongDao.class);
		//可以看出此时2个实例的hashcode不一样了  原型生效
		//System.out.println(yaoyongDao.hashCode());
		//System.out.println(yaoyongDao1.hashCode());

//		TestImportSelectorDao bean = annotationConfigApplicationContext.getBean(TestImportSelectorDao.class);
//		bean.query();
        //代理
//		TestAopDao testAopDao = (TestAopDao) annotationConfigApplicationContext.getBean("testAopDaoImpl");
//		testAopDao.query();
		//如果appconfig上加了@Configration就开启了cglib代理  全注解类
		//AppConfig appConfig = (AppConfig) annotationConfigApplicationContext.getBean("appConfig");

	    //cglib  进行方法拦截
		Enhancer enhancer =new Enhancer();
		enhancer.setSuperclass(TestCglib.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		enhancer.setCallback(new MyMethodCallBack());
		TestCglib testCglib = (TestCglib) enhancer.create();
		testCglib.query();
	}
}
