package com.ley.mybatis;

import org.junit.Before;
import com.ley.mybatis.code.generator.properties.ClasspathProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * 测试{{@link ClasspathProperties}}
 * **/
public class DataSourcePropertiesTest {

    private ClasspathProperties dataSourceProperties;

    @Before
    public void init(){
        dataSourceProperties=new ClasspathProperties("datasource.properties");
    }

    @Test
    public void testDataSourceProperties() throws IOException {
        final Properties properties=dataSourceProperties.getProperties();
        System.out.println(properties);
    }
}
