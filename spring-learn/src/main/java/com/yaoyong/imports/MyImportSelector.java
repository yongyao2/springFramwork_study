package com.yaoyong.imports;

import com.yaoyong.annotation.EnableYaoyong;
import com.yaoyong.dao.TestImportSelectorDao;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

//模拟aop  动态开关操作
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{TestImportSelectorDao.class.getName()};
	}
}
