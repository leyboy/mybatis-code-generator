package com.ley.mybatis;

import com.ley.mybatis.code.generator.velocity.utils.MybatisGeneratorVelocityContextUtils;
import org.junit.Test;

public class VelocityContextUtilsTest {

    @Test
    public void testVelocityContext(){
        MybatisGeneratorVelocityContextUtils contextUtils=new MybatisGeneratorVelocityContextUtils("datasource.properties","config/code-generator.properties","templates/mybatis-generator-config.vm");
        contextUtils.initVelocityContext();
    }

}
