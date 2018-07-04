package com.ley.mybatis.code.generator.utils;

import com.ley.mybatis.code.generator.bean.DataSourceBean;
import com.ley.mybatis.code.generator.commons.CodeGeneratorConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;

/**
 * Data source utility class
 * <br/>
 * 主要用来初始化{@link com.ley.mybatis.code.generator.bean.DataSourceBean}
 **/
public class DataSourceBeanUtils extends AbstractBeanUtils {

    private static final Log logger= LogFactory.getLog(DataSourceBeanUtils.class);


    public DataSourceBeanUtils(String resource) {
        super(resource);
    }

    @Override
    public DataSourceBean initBean() {
        Properties properties = getProperties();
        logger.debug("datasource properties: "+properties);
        DataSourceBean dataSource = new DataSourceBean();
        dataSource.setUsername(properties.getProperty(CodeGeneratorConstants.DATASOURCE_USERNAME));
        dataSource.setPassword(properties.getProperty(CodeGeneratorConstants.DATASOURCE_PASSWORD));
        //对jdbcUrl中&分隔符进行处理,转换为&amp;
        String jdbcUrl=properties.getProperty(CodeGeneratorConstants.DATASOURCE_JDBC_URL);
        jdbcUrl=jdbcUrl.replaceAll("&","&amp;");
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClassName(properties.getProperty(CodeGeneratorConstants.DATASOURCE_DRIVER_CLASS_NAME));
        if(logger.isDebugEnabled()){
            logger.debug("初始化dataSourceBean: "+dataSource);
        }
        return dataSource;
    }
}
