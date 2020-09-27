package com.yaoyong.annotation;


import com.yaoyong.beanDefinitionRegistrar.MyBeanDefinitionRegistrar;
import com.yaoyong.imports.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MyImportSelector.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableYaoyong {
//	/**
//	 * 是否开启,默认开启
//	 */
//	boolean isOpen() default true;
}
