package com.yaoyong.dao;


import com.yaoyong.test.SpringTest;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Role;
import org.springframework.lang.Nullable;

import java.lang.annotation.Documented;

public interface TestMyBatisDao {

    @Select("select *  from  user")
	public void  select();


}
