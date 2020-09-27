package com.yaoyong.annotation;


import com.yaoyong.beanDefinitionRegistrar.MyBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MyBeanDefinitionRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface YaoyongScan {
}
