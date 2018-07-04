package com.ley.mybatis;

import com.ley.mybatis.code.generator.bean.DataSourceBean;
import com.ley.mybatis.code.generator.utils.DataSourceBeanUtils;
import org.junit.Test;

public class DataSourceUtilsTest {

    @Test
    public void testDataSourceUtils(){
        DataSourceBeanUtils dataSourceUtils=new DataSourceBeanUtils("datasource.properties");
        DataSourceBean dataSource=dataSourceUtils.initBean();
        System.out.println(dataSource);
    }
}
