package com.ley.mybatis;

import com.ley.mybatis.code.generator.bean.MybatisGeneratorBean;
import com.ley.mybatis.code.generator.utils.MybatisGeneratorBeanUtils;
import org.junit.Test;

public class MybatisGeneratorUtilsTest {

    @Test
    public void testInitMybatisGeneratorBean(){
        MybatisGeneratorBeanUtils mybatisGeneratorBeanUtils=new MybatisGeneratorBeanUtils( "config/code-generator.properties",
                "datasource.properties");
        MybatisGeneratorBean mybatisGeneratorBean=mybatisGeneratorBeanUtils.initBean();

    }
}
